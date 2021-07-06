package fr.epita.batches.marketing;

import javax.sql.DataSource;

import org.postgresql.Driver;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import fr.epita.etl.JobCompletionNotificationListener;
import fr.epita.etl.Person;
import fr.epita.etl.processors.PersonItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;




	@Bean
	public JdbcCursorItemReader<Contact> reader() {
		JdbcCursorItemReader<Contact> itemReader = new JdbcCursorItemReader();
		itemReader.setDataSource(dataSource());
		itemReader.setSql("select contact_email, contact_address, contact_first_name from contacts");
		itemReader.setRowMapper(new ContactRowMapper());
		return  itemReader;
	}
	@Bean
	public DataSource dataSource(){
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(Driver.class);
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/"); //TODO complete
		return dataSource;
	}

	@Bean
	public ContactEmailProcessor processor() {

	}

	@Bean
	public FlatFileItemWriter<Contact> writer() {
		//FlatFileItemWriter<Contact> --> FlatFile...Writer<Email>
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("marketing-email-job")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Contact, Contact> chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

}

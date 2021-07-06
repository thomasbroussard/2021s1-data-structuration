package fr.epita.batches.marketing;

import org.springframework.batch.item.ItemProcessor;

public class ContactEmailProcessor implements ItemProcessor<Contact, Contact> {

	@Override
	public Contact process(Contact contact) throws Exception {
		return null;
	}
}

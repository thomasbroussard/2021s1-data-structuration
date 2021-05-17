from lxml import etree
# read from xml
tree = etree.parse('C:/tmp/data-structuration/menu.xml')
root: etree.ElementBase = tree.getroot()
print(root)

elems = root.xpath("./food[./calories < 800]")
data = [[elem.find("./name").text, elem.find("./price").text, elem.find("./calories").text] for elem in elems]

result: str = ''

result += 'name, price, calories \n'
for row in data:
    result += '{}, {}, {}\n'.format(row[0], row[1][1:], row[2])

print(result)

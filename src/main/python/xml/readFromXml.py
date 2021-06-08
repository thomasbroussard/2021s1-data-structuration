from lxml import etree
# read from xml
tree = etree.parse('C:/tmp/data-structuration/menu.xml')
root: etree.ElementBase = tree.getroot()
print(root)

elems = root.findall("./food")
data = [[elem.find("./name").text, elem.find("./price").text] for elem in elems]
print(data)

val = etree.tostring(root, pretty_print=True)
print(val)

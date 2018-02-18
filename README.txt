1)create maven project, archetype - webapp.
2)change web.xml header to:
	"<?xml version="1.0" encoding="UTF-8"?>
	<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
        version="3.1">"
  this change allow us use jstl library for more comfort work with jsp.
3)add maven dependency:
	<dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
    </dependency>

    <dependency>
        <groupId>taglibs</groupId>
        <artifactId>standard</artifactId>
        <version>1.1.2</version>
    </dependency>

    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
        <version>1.1.2</version>
    </dependency>
4)create POJO model class Item
5)create class ItemsServlet extend HttpServlet, override method doGet(). without jsp support, only "Hello world!".
6)add servlet, servlet-mapping to web.xml
7)configure tomcat server. test.
8)add JSP in project. jsp with table for items. use scriplets/jstl for output info from servlet.
9)rewrite doGet() method. add RequestDispatcher for set concrete jsp page for this method. add dispatcher.forward(req, resp);
10)parse file(txt, json, xml) with items and add each item into List<Item>.
11)setAttribute("attr name", attr object); test.
12)finish.
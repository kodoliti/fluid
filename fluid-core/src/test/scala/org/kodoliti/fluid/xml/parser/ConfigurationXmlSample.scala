package org.kodoliti.fluid.xml.parser

import xml.{XML, Elem}


trait ConfigurationXmlSample {

  def basicConfiguration(): Elem = {
    XML.loadString("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
      "<fluid xmlns=\"http://kodoliti.org/schema/fluid\"\n\t  " +
      "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\t   " +
      "xsi:schemaLocation=\"http://kodoliti.org/schema/fluid http://kodoliti.org/schema/fluid-schema.xsd\">\n" +
      "    <configuration>\n" +
      "        <grid>\n" +
      "         <nodes>\n" +
      "           <node id=\"1\" address=\"192.168.1.10\" />\n" +
      "           <node id=\"2\" address=\"192.168.1.11\" />\n" +
      "         </nodes>\n" +
      "        </grid>\n" +
      "        <persistence>\n" +
      "            <provider type=\"MONGODB\" />\n" +
      "               <connection-conf driverClass=\"\" \n" +
      "                                host=\"127.0.0.1\" \n" +
      "                                port=\"27017\" \n" +
      "                                username=\"\" \n" +
      "                                password=\"\" /> \n" +
      "        </persistence>\n" +
      "    </configuration>\n" +
      "    <process>\n" +
      "        <diagram location=\"\" />\n\n" +
      "        <service-tasks>\n" +
      "            <task class=\"\" ></task>\n" +
      "        </service-tasks>\n" +
      "    </process>\n" +
      "</fluid>")
  }


  def basicConfiguration2(): Elem = {
    <fluid>
      <configuration>
        <grid>
          <nodes>
            <node id=" " address=" "/>
          </nodes>
        </grid>
        <persistence>
          <provider type="MONGODB"/>
        </persistence>
      </configuration>
      <process>
        <diagram location=" "/>
        <service-tasks>
          <task class=" ">
          </task>
        </service-tasks>
      </process>
    </fluid>
  }


}
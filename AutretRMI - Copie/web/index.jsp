<%@ page import="org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: Alexa
  Date: 04/03/2016
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%
  // si clic sur bouton envoyer
// utilisation librairie apachen fileupload et commons-io
if(ServletFileUpload.isMultipartContent(request))
{
    FileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List items = upload.parseRequest(request);
    Iterator iter = items.iterator();
    while(iter.hasNext())
    {
        FileItem item = (FileItem) iter.next();
        if(item.isFormField())
        {
            String nom = item.getFieldName();
            String val = item.getString();
            System.out.println("val = " + val);
        }
    }

    String sql = "insert into t_ilmage(imblob) values(?)";
    PreparedStatement ps = null;

    ps.setBinaryStream(1, item.getInputStream());
    ps.executeUpdate();
}
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>File Upload</title>
  </head>
  <body>
  <form method="post" enctype="multipart/form-data">

        <input type="text" />
        <br /><br />
        <input type="file" />
        <input type="button" />
  </form>
  </body>
</html>

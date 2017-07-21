<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:form action="/login">
    <table border="0">
        <thead>
        <tr>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Enter your login:</td>
            <td><html:text property="login" /></td>
        </tr>
        <tr>
            <td>Enter your password:</td>
            <td><html:text property="password" /></td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit value="Login" /></td>
        </tr>
        </tbody>
    </table>



</html:form>

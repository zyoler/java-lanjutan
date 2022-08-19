<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        INSERT BOOK
    </title>
</head>
<body>
<form:form modelAttribute="bookDto" action="/saveBook" method="POST">
    <table>
        <tr>
            <td>Title</td>
            <td><form:input path="title" type="text"/>
        </tr>
        <tr>
            <td>ISBN</td>
            <td><form:input path="isbn" type="text"/></td>
        </tr>
        <tr>
            <td>Rating</td>
            <td><form:input path="rating" type="number"/></td>
        </tr>
        <tr>
            <td>Published Date</td>
            <td><form:input path="published_date" type="date"/></td>
        </tr>
        <tr>
            <td>Total Pages</td>
            <td><form:input path="total_pages" type="int"/></td>
        </tr>
    </table>

    <form:button type="submit" id="save" >Simpan</form:button>
</form:form>
</body>
</html>
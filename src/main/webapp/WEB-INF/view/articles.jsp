<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Articles</title>
</head>
<body>
<div>
    <form:form modelAttribute="articleType" action="/articles">
        <form:label path="id">Выбрать тип: </form:label>
        <form:select path="id">
            <form:option value="">Не выбран</form:option>
            <form:options items="${types}" itemLabel="name" itemValue="id"/>
        </form:select>
        <input type="submit" value="Поиск">
    </form:form>
</div>
<c:choose>
    <c:when test="${fn:length(articles) gt 0}">
        <div>
            <table border="1" cellpadding="5">
                <caption><h2>Статьи</h2></caption>
                <tr>
                    <th>Наименование статьи</th>
                    <th>Тип статьи</th>
                    <th>Количество официальных текстов</th>
                    <th>Количество английских текстов</th>
                </tr>
                <c:forEach items="${articles}" var="article">
                    <tr>
                        <td><c:out value="${article.name}"/></td>
                        <td><c:out value="${article.articleType.name}"/></td>
                        <td><c:out value="${article.getCountRefArticlesByTypeId(4)}" /></td>
                        <td><c:out value="${article.getCountRefArticlesByTypeId(5)}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <div>Нет статей с выбранным типом</div>
    </c:otherwise>
</c:choose>
</body>
</html>
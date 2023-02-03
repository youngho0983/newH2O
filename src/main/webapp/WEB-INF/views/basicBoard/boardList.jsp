<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2023-02-03
  Time: 오후 10:10
  To change this template use File | Settings | File Templates.
--%>

    <c:forEach items="#{boardList}" var="board">
        <div class="board_list">
            <a class="list_title" href="board/${board.boardnum}"><c:out value="${board.title}"/></a> |
            <a class="list_writer"><c:out value="${board.writer}"/></a>
        </div>
    </c:forEach>


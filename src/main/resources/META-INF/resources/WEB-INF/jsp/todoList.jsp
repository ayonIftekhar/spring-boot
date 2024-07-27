<%@ taglib prefix="c" uri="jakarta.tags.core" %>

  <%@ include file="commons/header.jspf" %>
  <div class="container">
    <h1> Welcome ${username} </h1>
    </hr>

    <table class="table">
        <thead>
            <tr>
                <th>Description</th> <th>Target Time</th> <th> Is Done </th> <th> </th>
            </tr>
        </thead>

        <tbody>

            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.getDescription()}</td> <td>${todo.getTarget()}</td> <td>${todo.getIsDone()}</td>
                    <td> <a href="delete-todo?id=${todo.getSerialNo()}"
                                class="btn btn-warning"> Delete </a></td>
                    <td> <a href="update-todo?id=${todo.getSerialNo()}"
                                class="btn btn-success"> Update </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/add-todo" class="btn btn-success"> Add New </a>

  </div>

    <%@ include file="commons/footer.jspf" %>
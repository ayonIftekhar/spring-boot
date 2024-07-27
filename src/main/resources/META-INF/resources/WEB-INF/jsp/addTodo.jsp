

  <%@ include file="commons/header.jspf" %>

  <div class="container">
    <form:form class="mt-3" method="post" modelAttribute="todo">

      <fieldset class="mb-3">
        <form:label path="description"> description : </form:label>
        <form:input type="text" required="required" path="description"/>
        <form:errors path="description" cssClass="text-warning"/>
      </fieldset>

      <fieldset class="mb-3">
        <form:label path="target"> Target Date : </form:label>
        <form:input class="text" required="required" path="target"/>
        <form:errors path="target" cssClass="text-warning"/>
      </fieldset>

        <input type="submit" value="Submit" class="btn btn-success"/>
        <form:input type="hidden"  path="serialNo"/>
        <form:input type="hidden"  path="isDone"/>

    </form:form>

  <div class="container">

    <%@ include file="commons/footer.jspf" %>

    <script type="text/javascript">
    $('#target').datepicker({
        format: 'yyyy-mm-dd',
        startDate: '-3d'
    });
    </script>
<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>


<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@ include file="vehicle_sidebar.jsp"%>
        <div id="main-wrapper "class="col-sm-10">
            <div class="col-sm-12">

<%--                LIST OF EXISTING ELEMENTS--%>
                <table class="table table-stripped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Vehicle Make</th>
                            <th>Vehicle Model</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="vehicleMake" items="${vehicleMakeList}" >
                            <tr>
                                <td>${vehicleMake.id}</td>
                                <td>${vehicleMake.name}</td>
                                <td>${vehicleMake.printModelList()}</td>
                                <td><a href="/admin/vehicle/modeledit/${vehicleMake.id}">Edit</a></td>
                                <td><a href="/admin/vehicle/modeldelete/${vehicleMake.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
</div>

<%@ include file="../../includes/footer.jsp"%>
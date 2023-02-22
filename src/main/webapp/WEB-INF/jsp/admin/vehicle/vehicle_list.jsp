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
                    <th>Vin</th>
                    <th>License Plate</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Sold</th>
                    <th>Purchase date</th>
                    <th>Model</th>
                    <th>Make</th>


                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${vehicleList}" >
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.vin}</td>
                        <td>${vehicle.licensePlate}</td>
                        <td>${vehicle.year}</td>
                        <td>${vehicle.price}</td>
                        <td>${vehicle.sold}</td>
                        <td>${vehicle.purchaseDate}</td>
                        <td>${vehicle.vehicleModel}</td>
                        <td>${vehicle.vehicleMake}</td>
                        <td><a href="/admin/vehicle/vehicleedit/${vehicle.id}">Edit</a></td>
                        <td><a href="/admin/vehicle/vehicledelete/${vehicle.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp"%>
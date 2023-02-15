<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>

<script>

    $(document).ready(function () {
        //attach an onclick function to the remove buttons
        $('.remove_button').click(function () {
            //lof name button. and contents of associated text box
            console.log(this.name);
            console.log($('#'+this.name).val())
            //clear the value / contents of the text box
            $('#'+ this.name).val('');
            //submit the form
            $('#vehicle').submit();
        });
    });
</script>


<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@ include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper "class="col-sm-10">
        <div class="col-sm-8">

            <%--                LIST OF EXISTING ELEMENTS--%>
            <c:set var="idx" value="0" scope="page"/>
            <form:form class="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/updatevehicle" method="post">
                <form:hidden path="id"/>
                <form:hidden path="version"/>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicle" class="col-sm-2 control-label">Vehicle Vin</label>
                        <div class="col-sm-8">
                            <form:input path="vin" type="text" id="inputVehicle" cssClass="form-control"></form:input>
                            <label for="inputVehicle" class="col-sm-2 control-label">License Plate</label>
                            <form:input path="licensePlate" type="text" id="inputVehicle" cssClass="form-control"></form:input>
                            <label for="inputVehicle" class="col-sm-2 control-label">Year</label>
                            <form:input path="year" type="text" id="inputVehicle" cssClass="form-control"></form:input>
                            <label for="inputVehicle" class="col-sm-2 control-label">Price</label>
                            <form:input path="price" type="text" id="inputVehicle" cssClass="form-control"></form:input>
                            <label for="inputVehicle" class="col-sm-2 control-label">Sold</label>
                            <form:input path="sold" type="text" id="inputVehicle" cssClass="form-control"></form:input>
                            <label for="inputVehicle" class="col-sm-2 control-label">Purchase Date</label>
                            <form:input path="purchaseDate" type="text" id="inputVehicle" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>

<%--                <c:forEach items="${vehicleMake.vehicleModelList}" var="vehicleModelList">--%>
<%--                    <form:hidden path="vehicleModelList[${idx}].id"/>--%>
<%--                    <form:hidden path="vehicleModelList[${idx}].version"/>--%>
<%--                    <div class="row">--%>
<%--                        <div class="form-group">--%>
<%--                            <label class="col-sm-3 control-label" for="${idx}">Model</label>--%>
<%--                            <div class="col-sm-7">--%>
<%--                                <div class="input-group">--%>
<%--                                    <form:input path="vehicleModelList[${idx}].name" id="${idx}" cssClass="form-control"/>--%>
<%--                                    <span class="input-group-btn">--%>
<%--                                        <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>--%>
<%--                                    </span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <c:set var="idx" value="${idx + 1}" scope="page"/>--%>
<%--                </c:forEach>--%>




                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>

            </form:form>

        </div>

        <div class="col-sm-4">

            <%--            Sucess Alert--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>

            <%--                Warning Alert--%>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Warning!</h4>
                    <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>

            <%--                Error Alert--%>
            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp"%>
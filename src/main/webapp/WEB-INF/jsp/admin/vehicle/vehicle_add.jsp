<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<script>

    $(document).ready(function () {

        $("#successAlert").delay(8000).fadeOut(2000)
        $("#warningAlert").delay(10000).fadeOut(2000)
    })
</script>


<div class="wrapper">

    <%--    SIDEBAR HERE--%>
    <%@ include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper " class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vo" action="/admin/vehicle/add" method="post">
                <fieldset>

                    <legend>New Make and Models</legend>
                    <div class="form-group">
                        <label for="inputNewVehicleMakeModel" class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-lg-10">
                            <form:input path="vehicleMake.name" type="text" class="form-contorl"
                                        id="inputNewVehicleMakeModel" placeholder="Make"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleMakeModel" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10">
                            <form:textarea path="vehicleModel.name" class="form-contorl" rows="3"
                                           id="inputNewVehicleMakeModel" placeholder="Models"></form:textarea>
                            <span class="help-block">Enter each new Model on a new Line</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>

                        </div>
                    </div>


                </fieldset>
            </form:form>

        </div>

        <div class="col-sm-4">
            <%--            Alerts--%>


            <%--            Sucess Alert--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Element added successfully!</strong> You successfully read <a href="#" class="alert-link">this
                    important alert message</a>.
                </div>
            </div>

            <%--                Warning Alert--%>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Warning!</h4>
                    <p>All fields required. please enter an Element Type and associated Elements only<a href="#"
                                                                                                        class="alert-link">vel
                        scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>

            <%--                Error Alert--%>
            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try
                    submitting again.
                </div>
            </div>


        </div>


        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vo" action="/admin/vehicle/add" method="post">
                <fieldset>

                    <legend>New Vehicle</legend>
                        ${vo.vehicle.vin}
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Select a Model</label>
                        <div style="color: black" class="col-lg-10">
                            <form:select path="vehicleModel.name" type="text" class="form-contorl" id="inputNewVehicle"
                                        placeholder="Model">
                                <c:forEach var="model" items="${vo.vehicleMake.vehicleModelList}">
                                    <form:option value="${model.name}" />
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Color</label>
                        <div class="col-lg-10">
                            <form:input path="vehicle.color" class="form-contorl" rows="3" id="inputNewVehicle"
                                        placeholder="Color"></form:input>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Vin</label>
                        <div class="col-lg-10">
                            <form:input path="vehicle.vin" class="form-contorl" rows="3" id="inputNewVehicle"
                                        placeholder="Vin"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Year</label>
                        <div class="col-lg-10">
                            <form:input path="vehicle.year" class="form-contorl" rows="3" id="inputNewVehicle"
                                        placeholder="Year"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Price</label>
                        <div class="col-lg-10">
                            <form:input path="vehicle.price" class="form-contorl" rows="3" id="inputNewVehicle"
                                        placeholder="Price"></form:input>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Purchase Date</label>
                        <div class="col-lg-10">
                            <form:input path="vehicle.purchaseDate" class="form-contorl" rows="3" id="inputNewVehicle"
                                        placeholder="Purchase Date"></form:input>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Sold</label>
                        <div class="col-lg-10">
                            <form:input path="vehicle.sold" class="form-contorl" rows="3" id="inputNewVehicle"
                                        placeholder="True/False"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="vehicle.licensePlate" class="form-contorl" rows="3" id="inputNewVehicle"
                                        placeholder="License Plate"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>
                </fieldset>
            </form:form>

        </div>
    </div>
</div>


<%@ include file="../../includes/footer.jsp" %>
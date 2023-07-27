<%--
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    <style>
        img{
            width: 200px;
            height: 120px;
        }
    </style>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manage <b>Product</b></h2>
                </div>

                <div class="col-sm-6">






                    <form  action="ViewCalendar.html" method="get">

                        <div style="margin-top: 5px; margin-left: 350px;">
                            <label>Month</label>
                            <select style="color: #000"  name="month" class="form-select" aria-label="Default select example">
                                <c:forEach items="${List_lsp}" var="lsp">
                                    <option  value="${lsp}">${lsp}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div style="margin-top: 5px; margin-left: 350px;">
                            <label>Year</label>
                            <select style="color: #000"  name="year" class="form-select" aria-label="Default select example">
                                <c:forEach items="${lst_year}" var="lsp">
                                    <option  value="${lsp.getYear()}">${lsp.getYear()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div style="margin-top: -40px">
                            <input type="submit" class="btn btn-success" value="Xem Lịch">
                        </div>



                    </form>


                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Khách Hàng</th>

                <c:forEach items="${lst_hd}" var="hd">
                    <th>${hd.getNgayLap()} </th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${lst_hd}" var="hd">
                <tr>
                    <td>${hd.getTenKhachHang()}</td>

                    <c:forEach begin = "1" end ="${hd.getIndex()}">
                        <td></td>
                    </c:forEach>

                    <td>${hd.getTongTien()}</td>

                </tr>

            </c:forEach>

            </tbody>
        </table>
        <div class="clearfix">
            <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
            <ul class="pagination">
                <c:forEach items="${list_T}" var="T">
                    <li class="${T.getStatus()}"><a href="ManagerCustomer.html?Trang=${T.getSoTrang()}" class="page-link">${T.getSoTrang()}</a></li>
                </c:forEach>
            </ul>
        </div>

    </div>
    <a href="Home.html"><button type="button" class="btn btn-primary">Back to home</button></a>


</div>


<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>
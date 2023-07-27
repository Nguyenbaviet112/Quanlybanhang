<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="shopping-cart">
    <div class="px-4 px-lg-0">

        <div class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                        <!-- Shopping cart table -->
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Đơn Giá</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Số Lượng</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Xóa</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cartItems}" var="item">
                                    <tr>
                                        <th scope="row">
                                            <div class="p-2">
                                                <img src="images/${item.getHinhURL()}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                <div class="ml-3 d-inline-block align-middle">
                                                    <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${item.getTenSanPham()}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                </div>
                                            </div>
                                        </th>
                                        <td class="align-middle"><strong>${item.getGiaSanPham()}</strong></td>
                                        <td class="align-middle">
                                            <a href="CartUpdate.html?SoLuongMua=${item.getSoLuongMua() - 1}&MaSanPham=${item.getMaSanPham()}"><button class="btnSub">-</button></a>
                                            <strong>${item.getSoLuongMua()}</strong>
                                            <a href="CartUpdate.html?SoLuongMua=${item.getSoLuongMua() + 1}&MaSanPham=${item.getMaSanPham()}"><button class="btnAdd">+</button></a>
                                        </td>
                                        <td class="align-middle"><a href="CartAdd.html?ac=remove&MaSanPham=${item.getMaSanPham()}" class="text-dark">
                                            <button type="button" class="btn btn-danger">Delete</button>
                                        </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- End -->
                    </div>
                </div>

                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                        <div class="p-4">
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${TongTien} đ</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền sau khi giảm giá theo sản phẩm</strong><strong>${TTSanPhamSauKM} đ</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng Tiền Khuyễn Mãi</strong><strong>${khuyenmai} đ</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                    <h5 class="font-weight-bold">${sum} đ</h5>
                                </li>
                            </ul><a href="#PhieuXuat"  class="btn btn-success" data-toggle="modal"><i >&#xE147;</i> <span>Xác Nhận Mua Hàng</span></a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="PhieuXuat" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="PhieuXuat.html" method="get">
                <div class="modal-header">
                    <h4 class="modal-title">Phiếu Xuất</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên Đang Nhập:</label>
                        <label name="tendangnhap" type="text" class="form-control" >${Tendangnhap}</label>
                    </div>
                    <div class="form-group">
                        <label>Số Tiền Trước Khi Thanh Toán</label>
                        <label name="SoTienTruocThanhToan" type="text" class="form-control" required>${sodu}</label>
                    </div>
                    <div class="form-group">
                        <label>Số Tiền Thanh Toán</label>
                        <label name="SoTienThanhToan" type="text" class="form-control" required>${sum}</label>
                    </div>
                    <div class="form-group">
                        <label>Số Dư Còn Lại</label>
                        <label name="SoDu" type="text" class="form-control" required>${soduconlai}</label>
                    </div>
                    <div class="form-group">
                        <label>Ngày Thanh Toán</label>
                        <label name="NgayThanhToan" type="text" class="form-control" required>${date}</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <a href="Bill.html?TenDangNhap=${Tendangnhap}&TongGia=${sum}"><button type="button" class="btn btn-primary">Xác Nhận Thanh Toán</button> </a>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
</html>

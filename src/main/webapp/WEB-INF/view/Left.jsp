
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${list_lsp}" var="lsp">
                <li class="list-group-item text-white ${tag == lsp.getMaLoaiSanPham() ? "active" : ""} "><a href="Category.html?MaLoaiSanPham=${lsp.getMaLoaiSanPham()}">${lsp.getTenLoaiSanPham()}</a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="images/${spm.getHinhURL()}" />
            <h5 class="card-title">${spm.getTenSanPham()}</h5>
            <p class="card-text">${spm.getMoTa()}</p>
            <p class="bloc_left_price">${spm.getGiaSanPham()}đ</p>
        </div>
    </div>
</div>
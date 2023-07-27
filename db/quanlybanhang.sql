-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2021 at 08:29 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlybanhang`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountlogin`
--

CREATE TABLE `accountlogin` (
  `MaAC` int(11) NOT NULL,
  `TenDangNhap` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MatKhau` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TenHienThi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BiXoa` int(11) DEFAULT NULL,
  `MaLoaiTaiKhoan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `accountlogin`
--

INSERT INTO `accountlogin` (`MaAC`, `TenDangNhap`, `MatKhau`, `TenHienThi`, `BiXoa`, `MaLoaiTaiKhoan`) VALUES
(1, 'admin', 'admin', 'admin', 0, 2),
(2, 'nbviet', 'nbviet', 'Bá Việt', 0, 2),
(3, 'tdhieu', 'tdhieu', 'Trương Hiếu', 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `chitietdondathang`
--

CREATE TABLE `chitietdondathang` (
  `MaChiTietDonDatHang` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `GiaBan` int(11) DEFAULT NULL,
  `MaDonDatHang` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `MaSanPham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `congno`
--

CREATE TABLE `congno` (
  `MaCN` int(11) NOT NULL,
  `SoTienNo` double DEFAULT NULL,
  `ThoiGianNo` datetime DEFAULT NULL,
  `MaKH` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dondathang`
--

CREATE TABLE `dondathang` (
  `MaDonDatHang` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `NgayLap` datetime DEFAULT NULL,
  `TongThanhTien` int(11) DEFAULT NULL,
  `MaTaiKhoan` int(11) NOT NULL,
  `MaTinhTrang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hangsanxuat`
--

CREATE TABLE `hangsanxuat` (
  `MaHangSanXuat` int(11) NOT NULL,
  `TenHangSanXuat` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LogoURL` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BiXoa` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hangsanxuat`
--

INSERT INTO `hangsanxuat` (`MaHangSanXuat`, `TenHangSanXuat`, `LogoURL`, `BiXoa`) VALUES
(1, 'Nokia', 'nokia.png', 0),
(2, 'OPPO', 'oppo.png', 0),
(3, 'Vivo', 'vivo.png', 0),
(4, 'XiaoMi', 'xiaomi.png', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL,
  `GiaGoc` double DEFAULT NULL,
  `GiaCuoi` int(11) DEFAULT NULL,
  `TenSP` int(11) DEFAULT NULL,
  `KhuyenMai` varchar(200) COLLATE ucs2_unicode_ci NOT NULL,
  `MaSP` int(11) DEFAULT NULL,
  `MaKH` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ucs2 COLLATE=ucs2_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` int(11) NOT NULL,
  `TenKhachHang` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DienThoai` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKhachHang`, `TenKhachHang`, `DiaChi`, `DienThoai`, `Email`) VALUES
(6, 'Nguyễn Bá Việt', 'Đồng Nai', '0339705277', 'nbviet.vn'),
(7, 'Trương Đình Hiếu', 'Đồng Nai', '0145986234', 'HTruong@gmail.com'),
(8, 'Võ Công Minh', 'TP HCM', '0334587956', 'vcminh@gamil.com'),
(9, 'Lỷ Nhần Quắn', 'TP HCM', '0334512548', 'phongthuong@gamil.com'),
(10, 'Trương Hoàng Quân', 'Hải Dương', '334512564', 'thquan@gmail.com'),
(12, 'Trần Thị Thu Thảo', 'Đồng Nai', '339705278', 'ttth@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `khachhangkhuyenmai`
--

CREATE TABLE `khachhangkhuyenmai` (
  `MaKH` int(11) NOT NULL,
  `MaKM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhangkhuyenmai`
--

INSERT INTO `khachhangkhuyenmai` (`MaKH`, `MaKM`) VALUES
(6, 2),
(7, 4);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` int(11) NOT NULL,
  `Code` varchar(100) CHARACTER SET utf32 COLLATE utf32_unicode_ci DEFAULT NULL,
  `TenKM` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ThoiGianBD` datetime NOT NULL,
  `ThoiGianKT` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `Code`, `TenKM`, `ThoiGianBD`, `ThoiGianKT`) VALUES
(1, 'GG20%', 'Giảm giá 20%', '2021-07-10 10:45:53', '2021-07-20 10:45:53'),
(2, 'KHMN100K', 'Giảm giá cho khách hàng mua nhiều sản phẩm', '2021-07-10 10:45:53', '2021-07-20 10:45:53'),
(3, 'GG150K', 'Giảm giá 150000', '2021-07-10 10:45:53', '2021-07-20 10:45:53'),
(4, 'KHKM50%', 'khuyến mãi 50% cho khách hàng quen thuộc', '2021-07-01 11:01:09', '2021-07-20 11:01:09');

-- --------------------------------------------------------

--
-- Table structure for table `lichsugiaodich`
--

CREATE TABLE `lichsugiaodich` (
  `MaLS` int(11) NOT NULL,
  `ThoiGianGD` datetime DEFAULT NULL,
  `NapTien` double DEFAULT NULL,
  `RutTien` double DEFAULT NULL,
  `MaTK` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLoaiSanPham` int(11) NOT NULL,
  `TenLoaiSanPham` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BiXoa` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLoaiSanPham`, `TenLoaiSanPham`, `BiXoa`) VALUES
(1, 'Điện thoại cảm ứng', 0),
(2, 'Điện thoại phím', 0);

-- --------------------------------------------------------

--
-- Table structure for table `loaitaikhoan`
--

CREATE TABLE `loaitaikhoan` (
  `MaLoaiTaiKhoan` int(11) NOT NULL,
  `TenLoaiTaiKhoan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaitaikhoan`
--

INSERT INTO `loaitaikhoan` (`MaLoaiTaiKhoan`, `TenLoaiTaiKhoan`) VALUES
(1, 'User'),
(2, 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `phieuthu`
--

CREATE TABLE `phieuthu` (
  `MaPT` int(11) NOT NULL,
  `NgayLap` datetime DEFAULT NULL,
  `SoTienNop` double DEFAULT NULL,
  `MaKH` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieuthu`
--

INSERT INTO `phieuthu` (`MaPT`, `NgayLap`, `SoTienNop`, `MaKH`) VALUES
(1, '2021-07-13 00:00:00', 100000, 6),
(2, '2021-07-13 00:00:00', 100000, 6),
(3, '2021-07-13 00:00:00', 100000, 6),
(4, '2021-07-13 00:00:00', 100000, 7);

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPX` int(11) NOT NULL,
  `NgayLap` datetime DEFAULT NULL,
  `SoTienMua` double DEFAULT NULL,
  `MaKH` int(11) DEFAULT NULL,
  `SoTienTruocThanhToan` double DEFAULT NULL,
  `SoDuConLai` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `quycach`
--

CREATE TABLE `quycach` (
  `MaQC` int(11) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `GiaTien` int(11) DEFAULT NULL,
  `MaSP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `quycach`
--

INSERT INTO `quycach` (`MaQC`, `SoLuong`, `GiaTien`, `MaSP`) VALUES
(1, 10, 160000, 4),
(2, 20, 152000, 4),
(3, 20, 144000, 4),
(4, 10, 178000, 5),
(5, 10, 171000, 5),
(6, 20, 165000, 5),
(7, 10, 480000, 7),
(8, 20, 432000, 7),
(9, 10, 300000, 8),
(10, 20, 450000, 8),
(11, 10, 380000, 9),
(12, 20, 300000, 9);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSanPham` int(11) NOT NULL,
  `TenSanPham` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HinhURL` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GiaSanPham` int(11) DEFAULT NULL,
  `NgayNhap` datetime DEFAULT NULL,
  `SoLuongTon` int(11) DEFAULT NULL,
  `SoLuongBan` int(11) DEFAULT NULL,
  `SoLuocXem` int(11) DEFAULT NULL,
  `MoTa` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `BiXoa` tinyint(1) DEFAULT 0,
  `MaLoaiSanPham` int(11) NOT NULL,
  `MaHangSanXuat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSanPham`, `TenSanPham`, `HinhURL`, `GiaSanPham`, `NgayNhap`, `SoLuongTon`, `SoLuongBan`, `SoLuocXem`, `MoTa`, `BiXoa`, `MaLoaiSanPham`, `MaHangSanXuat`) VALUES
(4, 'Điện thoại Nokia 5.4', 'nokia-54-1.jpg', 160000, '2012-08-25 00:00:00', 14, 9, 25, 'Sau Nokia 5.3, HMD Global tiếp tục cho ra mắt chiếc điện thoại Nokia 5.4 với nhiều nâng cấp thiết kế, cấu hình cùng camera mạnh mẽ hứa hẹn sẽ làm hài lòng người sử dụng, ngay cả những người khó tính nhất.\r\nThiết kế nguyên khối bền bỉ chắc chắn\r\nMặc dù là một chiếc smartphone được sản xuất trong phân khúc giá tầm trung nhưng Nokia 5.4 không hề lỗi thời với lối thiết kế nguyên khối vô cùng cứng cáp, mặt lưng làm từ nhựa phủ bóng giả kính vô cùng sang trọng và bắt mắt.', 0, 1, 1),
(5, 'Điện thoại Nokia 3.4', 'nokia-34-1-1.jpg', 180000, '2012-05-01 00:00:00', 14, 6, 4, 'Nokia 3.4 sở hữu màn hình IPS LCD kích thước 6.39 inch độ phân giải HD+, màn hình có thiết kế theo kiểu đục lỗ đang là xu hướng, với một màn hình lớn thì bạn có thể tận dụng được tối đa khả năng hiển thị để phục vụ các nhu cầu như vui chơi, giải trí và làm việc.', 0, 1, 1),
(7, 'Điện thoại Nokia C20', 'nokia-c20-vang-1-1-org.jpg', 480000, '2012-09-12 00:00:00', 25, 2, 9, 'Nokia C20 được hoàn thiện từ chất liệu vỏ polycarbonate cứng cáp mang đến độ bền cao, bạn sẽ yên tâm hơn khi sử dụng hay mang đi trong mọi hoạt động hằng ngày.', 0, 1, 1),
(8, 'Điện thoại Nokia 2.4', 'nokia-24-xam-1-2-org.jpg', 300000, '2012-07-03 00:00:00', 30, 0, 8, 'Thiết kế mới, trẻ trung, năng động nhiều màu sắc\r\nNokia 2.4 mang ngôn ngữ thiết kế hoàn toàn khác với các thế hệ Nokia 2.2 hay Nokia 2.3 khi được trang bị mặt lưng 3D họa tiết phay xước độc đáo kết hợp cùng hiệu ứng chuyển đổi màu gradient đẹp mắt ấn tượng từ cái nhìn đầu tiên.', 0, 1, 1),
(9, 'Điện thoại Nokia 8000 4G', 'nokia-8000-4g-den-1-org.jpg', 380000, '2012-01-01 00:00:00', 24, 6, 14, 'Điểm nhấn phong cách\r\nChiếc điện thoại có khung và mặt lưng được làm từ nhựa với lớp vỏ sáng bóng như thủy tinh cao cấp và các màu sắc lấy cảm hứng từ đá quý, Nokia 8000 4G được thiết kế để tỏa sáng. Lớp hoàn thiện khung giữa mạ chrome sang trọng hoàn thiện vẻ ngoài.', 0, 2, 1),
(10, 'Điện thoại Nokia 6300 4G', 'nokia-6300-4g-1-1-org.jpg', 220000, '2012-08-15 00:00:00', 28, 7, 8, 'Giá trị cổ điển “hồi sinh”\r\nNokia 6300 4G vẫn mang dáng dấp của Nokia 6300 năm nào, chính là thiết kế cổ điển với những cải tiến mới hợp xu hướng người dùng. Tổng thể của chiếc máy nhỏ gọn cho việc cầm nằm chắc chắn và mang đến cảm giác thoải mái cho người dùng khi sử dụng.', 0, 2, 1),
(11, 'Điện thoại Nokia 210', 'nokia-210-den-1-org.jpg', 260000, '2012-09-01 00:00:00', 38, 3, 38, 'Màn hình:\r\n\r\nTFT LCD2.4\"65.536 màu\r\nSIM:\r\n\r\n2 SIM thườngHỗ trợ 2G\r\nDanh bạ:\r\n\r\n500 số\r\nThẻ nhớ:\r\n\r\nMicroSD, hỗ trợ tối đa 32 GB\r\nCamera sau:\r\n\r\n0.3 MP\r\nRadio FM:\r\n\r\nCó\r\nJack cắm tai nghe:\r\n\r\n3.5 mm\r\nPin:\r\n\r\n1020 mAh', 0, 2, 1),
(12, 'Điện thoại Nokia 150 (2020)', 'nokia-150-2020-den-1-org.jpg', 260000, '2012-10-02 00:00:00', 20, 0, 0, 'Cấu hình Điện thoại Nokia 150 (2020)\r\n\r\nMàn hình:\r\n\r\nTFT LCD2.4\"65.536 màu\r\nSIM:\r\n\r\n2 SIM thườngHỗ trợ 2G\r\nDanh bạ:\r\n\r\n800 số\r\nThẻ nhớ:\r\n\r\nMicroSD, hỗ trợ tối đa 32 GB\r\nCamera sau:\r\n\r\nVGA (480 x 640 pixels)\r\nRadio FM:\r\n\r\nCó\r\nJack cắm tai nghe:\r\n\r\n3.5 mm\r\nPin:\r\n\r\n1020 mAh', 0, 2, 1),
(13, 'Điện thoại Nokia 105 Single SIM', 'nokia-105-single-sim-2019-den-1-org.jpg', 920000, '2012-10-04 00:00:00', 10, 2, 14, 'Cấu hình Điện thoại Nokia 105 Single SIM\r\n\r\nMàn hình:\r\n\r\nTFT LCD1.77\"65.536 màu\r\nSIM:\r\n\r\n1 SIM thườngHỗ trợ 2G\r\nDanh bạ:\r\n\r\n2000 số\r\nRadio FM:\r\n\r\nCó\r\nJack cắm tai nghe:\r\n\r\n3.5 mm\r\nPin:\r\n\r\n800 mAh', 0, 2, 1),
(14, 'Điện thoại Nokia 5310 (2020)', 'nokia-5310-2020-trang-1-org.jpg', 240000, '2012-09-25 00:00:00', 5, 5, 1, 'Cấu hình Điện thoại Nokia 5310 (2020)\r\n\r\nMàn hình:\r\n\r\nTFT LCD2.4\"\r\nSIM:\r\n\r\n2 SIM thườngHỗ trợ 2G\r\nDanh bạ:\r\n\r\n2000 số\r\nThẻ nhớ:\r\n\r\nMicroSD, hỗ trợ tối đa 32 GB\r\nCamera sau:\r\n\r\nVGA (480 x 640 pixels)\r\nRadio FM:\r\n\r\nCó\r\nJack cắm tai nghe:\r\n\r\n3.5 mm\r\nPin:\r\n\r\n1200 mAh', 0, 2, 1),
(15, 'Điện thoại OPPO A74', 'oppo-a74-xanh-duong-1-org.jpg', 270000, '2012-08-27 00:00:00', 19, 3, 3, 'Cấu hình Điện thoại OPPO A74\r\n\r\nMàn hình:\r\n\r\nAMOLED6.43\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 2 MP, 2 MP\r\nCamera trước:\r\n\r\n16 MP\r\nChip:\r\n\r\nSnapdragon 662\r\nRAM: 8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n5000 mAh33 W', 0, 1, 2),
(16, 'Điện thoại OPPO Reno5', 'oppo-reno5-den-1-org.jpg', 190000, '2012-07-13 00:00:00', 50, 3, 5, 'Cấu hình Điện thoại OPPO Reno5\r\n\r\nMàn hình:\r\n\r\nAMOLED6.43\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 64 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước:\r\n\r\n44 MP\r\nChip:\r\n\r\nSnapdragon 720G\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4310 mAh50 W', 0, 1, 2),
(17, 'Điện thoại OPPO Find X3 Pro 5G', 'oppo-find-x3-pro-den-1-org.jpg', 180000, '2012-09-15 00:00:00', 60, 3, 2, 'Cấu hình Điện thoại OPPO Find X3 Pro 5G\r\n\r\nMàn hình:\r\n\r\nAMOLED6.7\"Quad HD+ (2K+)\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 50 MP & Phụ 50 MP, 13 MP, 3 MP\r\nCamera trước:\r\n\r\n32 MP\r\nChip:\r\n\r\nSnapdragon 888\r\nRAM:\r\n\r\n12 GB\r\nBộ nhớ trong:\r\n\r\n256 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 5G\r\nPin, Sạc:\r\n\r\n4500 mAh65 W', 0, 1, 2),
(18, 'Điện thoại OPPO Reno5 5G', 'oppo-reno5-5g-den--org.jpg', 200000, '2012-09-14 00:00:00', 30, 30, 22, 'Cấu hình Điện thoại OPPO Reno5 5G\r\n\r\nMàn hình:\r\n\r\nAMOLED6.43\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 64 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước:\r\n\r\n32 MP\r\nChip:\r\n\r\nSnapdragon 765G\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 5G\r\nPin, Sạc:\r\n\r\n4300 mAh65 W', 0, 1, 2),
(19, 'Điện thoại OPPO Reno4 Pro', 'oppo-reno4-pro-trang-1-org.jpg', 110000, '2012-06-12 00:00:00', 19, 13, 24, 'Cấu hình Điện thoại OPPO Reno4 Pro\r\n\r\nMàn hình:\r\n\r\nAMOLED6.5\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 10\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước:\r\n\r\n32 MP\r\nChip:\r\n\r\nSnapdragon 720G\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n256 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4000 mAh65 W', 0, 1, 2),
(20, 'Điện thoại OPPO A94', 'oppo-a94-den-11-org.jpg', 160000, '2012-07-12 00:00:00', 20, 12, 13, 'Cấu hình Điện thoại OPPO A94\r\n\r\nMàn hình:\r\n\r\nAMOLED6.43\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước:\r\n\r\n32 MP\r\nChip:\r\n\r\nMediaTek Helio P95\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4310 mAh30 W', 0, 1, 2),
(21, 'Điện thoại OPPO A74 5G', 'oppo-a74-5g-bac-4-org.jpg', 140000, '2012-08-17 00:00:00', 35, 12, 12, 'Cấu hình Điện thoại OPPO A74 5G\r\n\r\nMàn hình:\r\n\r\nIPS LCD6.5\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước:\r\n\r\n16 MP\r\nChip:\r\n\r\nSnapdragon 480 8 nhân 5G\r\nRAM:\r\n\r\n6 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 5G\r\nPin, Sạc:\r\n\r\n5000 mAh18 W', 0, 1, 2),
(22, 'Điện thoại OPPO Reno4', 'oppo-reno4-xanh-duong-1-org.jpg', 500000, '2012-10-05 00:00:00', 24, 28, 30, 'Cấu hình Điện thoại OPPO Reno4\r\n\r\nMàn hình:\r\n\r\nAMOLED6.4\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 10\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước:\r\n\r\nChính 32 MP & Phụ cảm biến thông minh A.I\r\nChip:\r\n\r\nSnapdragon 720G\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4015 mAh30 W', 0, 1, 2),
(23, 'Điện thoại OPPO A93', 'oppo-a93-den-4-org.jpg', 950000, '2012-10-07 00:00:00', 30, 2, 24, 'Cấu hình Điện thoại OPPO A93\r\n\r\nMàn hình:\r\n\r\nAMOLED6.43\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 10\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước:\r\n\r\nChính 16 MP & Phụ 2 MP\r\nChip:\r\n\r\nMediaTek Helio P95\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4000 mAh18 W', 0, 1, 2),
(24, 'Điện thoại OPPO A54', 'oppo-a54-den-5-org.jpg', 150000, '2012-10-08 00:00:00', 39, 2, 6, 'Cấu hình Điện thoại OPPO A54\r\n\r\nMàn hình:\r\n\r\nIPS LCD6.5\"HD+\r\nHệ điều hành:\r\n\r\nAndroid 10\r\nCamera sau:\r\n\r\nChính 13 MP & Phụ 2 MP, 2 MP\r\nCamera trước:\r\n\r\n16 MP\r\nChip:\r\n\r\nMediaTek Helio P35\r\nRAM:\r\n\r\n4 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n5000 mAh18 W', 0, 1, 2),
(25, 'Điện thoại OPPO A15s', 'oppo-a15s-xanh-1-org.jpg', 240000, '2012-09-07 00:00:00', 38, 2, 4, 'Cấu hình Điện thoại OPPO A15s\r\n\r\nMàn hình:\r\n\r\nLCD6.52\"HD+\r\nHệ điều hành:\r\n\r\nAndroid 10\r\nCamera sau:\r\n\r\nChính 13 MP & Phụ 2 MP, 2 MP\r\nCamera trước:\r\n\r\n8 MP\r\nChip:\r\n\r\nMediaTek Helio P35\r\nRAM:\r\n\r\n4 GB\r\nBộ nhớ trong:\r\n\r\n64 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4230 mAh10 W', 0, 1, 2),
(26, 'Điện thoại Vivo Y53s', 'vivo-y53s-xanh-tim-1-org.jpg', 620000, '2012-10-07 00:00:00', 20, 12, 30, 'Cấu hình Điện thoại Vivo Y53s\r\n\r\nMàn hình:\r\n\r\nIPS LCD6.58\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 64 MP & Phụ 2 MP, 2 MP\r\nCamera trước:\r\n\r\n16 MP\r\nChip:\r\n\r\nMediaTek Helio G80\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n5000 mAh33 W', 0, 1, 3),
(27, 'Điện thoại Vivo V21 5G', 'vivo-v21-5g-tim-hong-1-3-org.jpg', 223000, '2012-10-02 00:00:00', 20, 12, 3, 'Cấu hình Điện thoại Vivo V21 5G\r\n\r\nMàn hình:\r\n\r\nAMOLED6.44\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 64 MP & Phụ 8 MP, 2 MP\r\nCamera trước:\r\n\r\n44 MP\r\nChip:\r\n\r\nMediaTek Dimensity 800U 5G\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 5G\r\nPin, Sạc:\r\n\r\n4000 mAh33 W', 0, 1, 3),
(28, 'Điện thoại Vivo V20 (2021)', 'vivo-v20-2021-xanh-hong-1-org.jpg', 300000, '2012-10-01 00:00:00', 10, 1, 2, 'Cấu hình Điện thoại Vivo V20 (2021)\r\n\r\nMàn hình:\r\n\r\nAMOLED6.44\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 64 MP & Phụ 8 MP, 2 MP\r\nCamera trước:\r\n\r\n44 MP\r\nChip:\r\n\r\nSnapdragon 730\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4000 mAh33 W', 0, 1, 3),
(29, 'Điện thoại Vivo Y72 5G', 'vivo-y72-5g-den-1-org.jpg', 320000, '2012-09-30 00:00:00', 10, 3, 2, 'Cấu hình Điện thoại Vivo Y72 5G\r\n\r\nMàn hình:\r\n\r\nIPS LCD6.58\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 64 MP & Phụ 8 MP, 2 MP\r\nCamera trước:\r\n\r\n16 MP\r\nChip:\r\n\r\nMediaTek Dimensity 700\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIM (SIM 2 chung khe thẻ nhớ)Hỗ trợ 5G\r\nPin, Sạc:\r\n\r\n5000 mAh18 W', 0, 1, 3),
(30, 'Điện thoại Vivo V20 SE', 'vivo-v20-se-xanh-duong-nhat-1-org.jpg', 625000, '2012-10-01 00:00:00', 4, 2, 1, 'Cấu hình Điện thoại Vivo V20 SE\r\n\r\nMàn hình:\r\n\r\nAMOLED6.44\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 10\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 8 MP, 2 MP\r\nCamera trước:\r\n\r\n32 MP\r\nChip:\r\n\r\nSnapdragon 665\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n4100 mAh33 W', 0, 1, 3),
(31, 'Điện thoại Vivo Y51 (2020) ', 'vivo-y51-2020-tim-bac-4-org.jpg', 560000, '2012-10-05 00:00:00', 2, 6, 5, 'Cấu hình Điện thoại Vivo Y51 (2020)\r\n\r\nMàn hình:\r\n\r\nIPS LCD6.58\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 8 MP, 2 MP\r\nCamera trước:\r\n\r\n16 MP\r\nChip:\r\n\r\nSnapdragon 662\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 4G\r\nPin, Sạc:\r\n\r\n5000 mAh18 W', 0, 1, 3),
(32, 'Điện thoại Xiaomi Redmi Note 10 8GB ', 'xiaomi-redmi-note-10-5g-bac-1-org.jpg', 410000, '2012-10-06 00:00:00', 3, 0, 0, 'Cấu hình Điện thoại Xiaomi Redmi Note 10 5G 8GB\r\n\r\nMàn hình:\r\n\r\nIPS LCD6.5\"Full HD+\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 48 MP & Phụ 2 MP, 2 MP\r\nCamera trước:\r\n\r\n8 MP\r\nChip:\r\n\r\nMediaTek Dimensity 700\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n128 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 5G\r\nPin, Sạc:\r\n\r\n5000 mAh18 W', 0, 1, 4),
(33, 'Điện thoại Xiaomi Mi 11 5G', 'xiaomi-mi-11-xanhduong-1-org.jpg', 600000, '2012-10-06 00:00:00', 4, 0, 15, 'Cấu hình Điện thoại Xiaomi Mi 11 5G\r\n\r\nMàn hình:\r\n\r\nAMOLED6.81\"Quad HD+ (2K+)\r\nHệ điều hành:\r\n\r\nAndroid 11\r\nCamera sau:\r\n\r\nChính 108 MP & Phụ 13 MP, 5 MP\r\nCamera trước:\r\n\r\n20 MP\r\nChip:\r\n\r\nSnapdragon 888\r\nRAM:\r\n\r\n8 GB\r\nBộ nhớ trong:\r\n\r\n256 GB\r\nSIM:\r\n\r\n2 Nano SIMHỗ trợ 5G\r\nPin, Sạc:\r\n\r\n4600 mAh55 W', 0, 1, 4),
(41, 'iphone anime isukioooo', 'nokia-54-1.jpg', 100, '2021-02-02 00:00:00', NULL, NULL, NULL, 'anime sestion', 0, 1, 1),
(42, 'nani', 'nokia-54-1.jpg', 123, NULL, NULL, NULL, NULL, 'what up brl', 0, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sanphamkhuyenmai`
--

CREATE TABLE `sanphamkhuyenmai` (
  `MaSP` int(11) NOT NULL,
  `MaKM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanphamkhuyenmai`
--

INSERT INTO `sanphamkhuyenmai` (`MaSP`, `MaKM`) VALUES
(7, 2),
(9, 2),
(14, 1);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaTK` int(11) NOT NULL,
  `SoDu` double DEFAULT NULL,
  `MaKH` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`MaTK`, `SoDu`, `MaKH`) VALUES
(1, 5010000, 6),
(2, 12100000, 7);

-- --------------------------------------------------------

--
-- Table structure for table `tinhtrang`
--

CREATE TABLE `tinhtrang` (
  `MaTinhTrang` int(11) NOT NULL,
  `TenTinhTrang` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tinhtrang`
--

INSERT INTO `tinhtrang` (`MaTinhTrang`, `TenTinhTrang`) VALUES
(1, 'Đặt hàng'),
(2, 'Đang giao hàng'),
(3, 'Thanh toán'),
(4, 'Hủy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountlogin`
--
ALTER TABLE `accountlogin`
  ADD PRIMARY KEY (`MaAC`),
  ADD KEY `fk_ac_ltk` (`MaLoaiTaiKhoan`);

--
-- Indexes for table `chitietdondathang`
--
ALTER TABLE `chitietdondathang`
  ADD PRIMARY KEY (`MaChiTietDonDatHang`),
  ADD KEY `fk_ChiTietDonDatHang_DonDatHang1_idx` (`MaDonDatHang`),
  ADD KEY `fk_ChiTietDonDatHang_SanPham1_idx` (`MaSanPham`);

--
-- Indexes for table `congno`
--
ALTER TABLE `congno`
  ADD PRIMARY KEY (`MaCN`);

--
-- Indexes for table `dondathang`
--
ALTER TABLE `dondathang`
  ADD PRIMARY KEY (`MaDonDatHang`),
  ADD KEY `fk_DonDatHang_TaiKhoan1_idx` (`MaTaiKhoan`),
  ADD KEY `fk_DonDatHang_TinhTrang1_idx` (`MaTinhTrang`);

--
-- Indexes for table `hangsanxuat`
--
ALTER TABLE `hangsanxuat`
  ADD PRIMARY KEY (`MaHangSanXuat`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `fk_kh_sp` (`MaSP`),
  ADD KEY `fk_hd_kh` (`MaKH`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKhachHang`);

--
-- Indexes for table `khachhangkhuyenmai`
--
ALTER TABLE `khachhangkhuyenmai`
  ADD PRIMARY KEY (`MaKH`,`MaKM`),
  ADD KEY `fk_KHKM_KM` (`MaKM`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Indexes for table `lichsugiaodich`
--
ALTER TABLE `lichsugiaodich`
  ADD PRIMARY KEY (`MaLS`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLoaiSanPham`);

--
-- Indexes for table `loaitaikhoan`
--
ALTER TABLE `loaitaikhoan`
  ADD PRIMARY KEY (`MaLoaiTaiKhoan`);

--
-- Indexes for table `phieuthu`
--
ALTER TABLE `phieuthu`
  ADD PRIMARY KEY (`MaPT`),
  ADD KEY `fk_pt_kh` (`MaKH`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPX`),
  ADD KEY `fk_px_kh` (`MaKH`);

--
-- Indexes for table `quycach`
--
ALTER TABLE `quycach`
  ADD PRIMARY KEY (`MaQC`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSanPham`),
  ADD KEY `fk_SanPham_LoaiSanPham1_idx` (`MaLoaiSanPham`),
  ADD KEY `fk_SanPham_HangSanXuat1_idx` (`MaHangSanXuat`);

--
-- Indexes for table `sanphamkhuyenmai`
--
ALTER TABLE `sanphamkhuyenmai`
  ADD PRIMARY KEY (`MaSP`,`MaKM`),
  ADD KEY `fk_spkm_km` (`MaKM`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaTK`),
  ADD KEY `fk_taikhoan_khachhang` (`MaKH`);

--
-- Indexes for table `tinhtrang`
--
ALTER TABLE `tinhtrang`
  ADD PRIMARY KEY (`MaTinhTrang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accountlogin`
--
ALTER TABLE `accountlogin`
  MODIFY `MaAC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `congno`
--
ALTER TABLE `congno`
  MODIFY `MaCN` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hangsanxuat`
--
ALTER TABLE `hangsanxuat`
  MODIFY `MaHangSanXuat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKhachHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `MaKM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `lichsugiaodich`
--
ALTER TABLE `lichsugiaodich`
  MODIFY `MaLS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `MaLoaiSanPham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `loaitaikhoan`
--
ALTER TABLE `loaitaikhoan`
  MODIFY `MaLoaiTaiKhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `phieuthu`
--
ALTER TABLE `phieuthu`
  MODIFY `MaPT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `MaPX` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `quycach`
--
ALTER TABLE `quycach`
  MODIFY `MaQC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSanPham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MaTK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tinhtrang`
--
ALTER TABLE `tinhtrang`
  MODIFY `MaTinhTrang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accountlogin`
--
ALTER TABLE `accountlogin`
  ADD CONSTRAINT `fk_ac_ltk` FOREIGN KEY (`MaLoaiTaiKhoan`) REFERENCES `loaitaikhoan` (`MaLoaiTaiKhoan`);

--
-- Constraints for table `chitietdondathang`
--
ALTER TABLE `chitietdondathang`
  ADD CONSTRAINT `fk_ChiTietDonDatHang_DonDatHang1` FOREIGN KEY (`MaDonDatHang`) REFERENCES `dondathang` (`MaDonDatHang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ChiTietDonDatHang_SanPham1` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `dondathang`
--
ALTER TABLE `dondathang`
  ADD CONSTRAINT `fk_DonDatHang_TaiKhoan1` FOREIGN KEY (`MaTaiKhoan`) REFERENCES `khachhang` (`MaKhachHang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DonDatHang_TinhTrang1` FOREIGN KEY (`MaTinhTrang`) REFERENCES `tinhtrang` (`MaTinhTrang`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `fk_hd_kh` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKhachHang`),
  ADD CONSTRAINT `fk_kh_sp` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSanPham`);

--
-- Constraints for table `khachhangkhuyenmai`
--
ALTER TABLE `khachhangkhuyenmai`
  ADD CONSTRAINT `fk_KHKM_KH` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKhachHang`),
  ADD CONSTRAINT `fk_KHKM_KM` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`);

--
-- Constraints for table `phieuthu`
--
ALTER TABLE `phieuthu`
  ADD CONSTRAINT `fk_pt_kh` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKhachHang`);

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `fk_px_kh` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKhachHang`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `fk_SanPham_HangSanXuat1` FOREIGN KEY (`MaHangSanXuat`) REFERENCES `hangsanxuat` (`MaHangSanXuat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SanPham_LoaiSanPham1` FOREIGN KEY (`MaLoaiSanPham`) REFERENCES `loaisanpham` (`MaLoaiSanPham`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sanphamkhuyenmai`
--
ALTER TABLE `sanphamkhuyenmai`
  ADD CONSTRAINT `fk_spkm_km` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`),
  ADD CONSTRAINT `fk_spkm_sp` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSanPham`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `fk_taikhoan_khachhang` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKhachHang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

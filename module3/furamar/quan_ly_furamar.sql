drop database if exists quan_ly_furama;
create database quan_ly_furama;
use quan_ly_furama;
/* Tạo các bảng*/
create table vi_tri(
	id_vi_tri int primary key,
	ten_vi_tri varchar(45)
);
create table trinh_do(
	id_trinh_do int primary key,
	trinh_do varchar(45)
);
create table bo_phan(
	id_bo_phan int primary key,
	ten_bo_phan varchar(45)
);
create table nhan_vien(
	id_nhan_vien int primary key,
	ho_ten varchar(45),
	id_vi_tri int,
	id_trinh_do int,
	id_bo_phan int,
	ngay_sinh date,
	so_cmnd varchar(45),
	luong int,
	sdt varchar(45),
	email varchar(45),
	dia_chi varchar(45),
	foreign key(id_vi_tri) 
	references vi_tri(id_vi_tri) ,
	foreign key(id_trinh_do) 
	references trinh_do(id_trinh_do),
	foreign key(id_bo_phan) 
	references bo_phan(id_bo_phan)
    
);
create table loai_khach(
	id_loai_khach int primary key,
	ten_loai_khach varchar(45)
);
create table khach_hang(
	id_khach_hang int primary key,
	id_loai_khach int,
	ho_ten varchar(45),
	ngay_sinh date,
	so_cmnd varchar(45),
	sdt varchar(45),
	email varchar(45),
	dia_chi varchar(45),
	foreign key(id_loai_khach)
    references loai_khach(id_loai_khach)
);

create table kieu_thue(
	id_kieu_thue int primary key,
	ten_kieu_thue varchar(45),
	gia int
);
create table loai_dich_vu(
	id_loai_dich_vu int primary key,
	ten_loai_dich_vu varchar(45)
);
create table dich_vu(
	id_dich_vu int primary key,
	ten_dich_vu varchar(45),
	dien_tich int,
	so_tang int,
	so_nguoi_toi_da int,
	chi_phi_thue varchar(45),
	id_loai_dich_vu int,
	id_kieu_thue int,
	trang_thai varchar(45),
	foreign key(id_loai_dich_vu) 
    references loai_dich_vu(id_loai_dich_vu) ,
	foreign key(id_kieu_thue) 
    references kieu_thue(id_kieu_thue)
);
create table hop_dong(
	id_hop_dong int primary key,
	id_nhan_vien int,
	id_khach_hang int,
	id_dich_vu int,
	ngay_ky_hop_dong date,
	ngay_ket_thuc date,
	tien_dat_coc int,
	tong_tien int,
	foreign key(id_nhan_vien) 
    references nhan_vien(id_nhan_vien) ON DELETE CASCADE,
	foreign key(id_khach_hang) 
    references khach_hang(id_khach_hang)ON DELETE CASCADE,
	foreign key(id_dich_vu)
    references dich_vu(id_dich_vu) 
);


create table dich_vu_di_kem(
	id_dich_vu_di_kem int primary key,
	ten_dich_vu_di_kem varchar(45),
	gia int,
	don_vi int,
	trang_thai_kha_dung varchar(45)
);

create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int primary key,
	id_hop_dong int,
	id_dich_vu_di_kem int,
	so_luong int,
	foreign key(id_dich_vu_di_kem) 
    references dich_vu_di_kem(id_dich_vu_di_kem),
	foreign key(id_hop_dong) 
    references hop_dong(id_hop_dong) ON DELETE CASCADE
);
/*1.	Thêm mới thông tin cho tất cả các bảng có trong 
CSDL để có thể thõa mãn các yêu cầu bên dưới.*/

insert into vi_tri 
values
	(1,'Giám Đốc'),
	(2,'Giám sát'),
	(3,'Lễ Tân'),
	(4,'Phục vụ'),
	(5,'Quản lý'),
	(6,'Quản lý');
insert into trinh_do 
values
	(1,'Cao đẳng'),
	(2,'Đại học'),
	(3,'Cao đẳng'),
	(4,'Sau đại học'),
	(5,'Trung cấp'),
	(6,'Trung cấp');
insert into bo_phan 
values 
	(1,'Sale – Marketing'),
	(2,'Hành Chính'),
	(3,'Quản lý'),
	(4,'Phục vụ'),
	(5,'Quản lý'),
	(6,'Quản lý');
insert into nhan_vien 
values
    (1,'Nguyễn Tiến Hải',1,1,1,'2001/08/13','123415678',8000000,'0394772917','tienhai@gmail.com','hà tĩnh'),
    (7,'Nguyễn Tiến Hải1',1,1,1,'2001/08/13','123415678',8000000,'0394772917','tienhai@gmail.com','hà tĩnh'),
    (2,'Lê Nhật',2,2,2,'2000/01/01','123415677',2000000,'0394772917','lenhat@gmail.com','quảng trị'),
    (3,'Trần Thanh Hoàng',3,3,3,'1999/01/01','123415676',7000000,'0394772917','thanhhoang@gmail.com','vô gia cư'),
    (4,'Hữu Quang',4,4,4,'1996/01/01','123451675',5000000,'0394772917','huuquang@gmail.com','đà nẵng'),
    (5,'Lê Toàn',1,1,1,'1993/01/01','123451674',9000000,'0394772917','letoan@gmail.com','đà nẵng'),
    (6,'Lê Toàn1',1,1,1,'1993/01/01','123451674',5000000,'0294772917','letoan1@gmail.com','đà nẵng');
insert into loai_khach
values
	(1,'Diamond'),
	(2,'Gold'),
	(3,'Platinium'),
	(4,'Silver'),
	(5,'Member'),
	(6,'Member');
insert into khach_hang
values
    (1,3,'Văn Chương','1988/01/01','876543211','0394772917','vanchuong@gmail.com','Quảng Ngãi'),
    (2,1,'Quốc Khánh','1993/01/01','876514312','0394772917','quockhanh@gmail.com','Vinh'),
    (3,3,'Trần Đạt','1992/01/01',879761542,'0394772917','trandat@gmail.com','đà nẵng'),
    (4,3,'Hữu Hiên','1995/01/01',098765432,'0394772917','sontra@gmail.com','Quảng Ngãi'),
    (5,3,'Hữu Hiên','1994/01/01',123876549,'0394772917','huuhien@gmai.com','Quảng Ngãi'),
    (6,1,'Hữu Hiên2','1994/01/01',123876549,'0394772917','huuhien@gmai.com','Quảng trị');
insert into kieu_thue
values
    (1,'thuê theo ngày',500000),
    (2,'thuê theo tuần',100000),
    (3,'thuê theo tháng',900000),
    (4,'thuê theo ngày',300000),
    (5,'thuê theo tuần',100000),
    (6,'thuê theo tuần',100000);
insert into loai_dich_vu
values
    (1,'villa'),
    (2,'house'),
    (3,'room'),
    (4,'villa'),
    (5,'room'),
    (6,'room');
insert into dich_vu
values
    (1,'villa',300,2,5,400000,1,1,'mới'),
    (5,'villa',400,3,5,600000,5,5,'cũ'),
    (2,'house',200,3,6,300000,2,2,'mới'),
    (3,'room',100,1,3,200000,3,3,'cũ'),
    (4,'room',150,3,3,300000,4,4,'mới'),
    (6,'room',150,3,3,300000,4,4,'mới');
insert into hop_dong
values
	(1,3,1,1,'2013/10/20','2019/010/20',1000000,15000000),
	(2,2,1,2,'2018/01/20','2020/01/27',3000000,6000000),
	(3,5,3,3,'2011/02/20','2018/02/27',2000000,40000000),
	(4,2,4,4,'2016/08/20','2020/08/21',100000,1000000),
	(5,4,5,5,'2019/12/20','2014/10/20',2000000,5000000),
	(6,1,5,3,'2019/10/20','2018/12/20',2000000,5000000);
insert into dich_vu_di_kem
values
	(1,'karaoke',100000,4,'tốt'),
	(2,'karaoke',250000,9,'tốt'),
	(3,'thức ăn',200000,7,'tốt'),
	(4,'karaoke',10000,4,'tốt'),
	(5,'nước uống',500000,5,'tốt'),
	(6,'nước uống',500000,5,'tốt');
insert into hop_dong_chi_tiet
values
	(1,1,1,3),
	(2,2,1,9),
	(3,3,1,6),
	(4,4,1,5),
	(5,5,1,2),
	(6,5,1,2);
    
/*2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có 
tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

select *
from nhan_vien
where ((ho_ten 
	like "H%"
	or ho_ten
	like "T%"
	or ho_ten
	like "K%"
	)and length(ho_ten)<15
    );
/*3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 
50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/
select *
from khach_hang
where (
		((select (datediff(now(),ngay_sinh)/365)) 
		between 18
		and 50) 
    and 
		(khach_hang.dia_chi='đà nẵng' 
		or  khach_hang.dia_chi='quảng trị'));

/*4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
 lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
 khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
select khach_hang.id_khach_hang, khach_hang.ho_ten,count(khach_hang.id_khach_hang)
from khach_hang 
inner join hop_dong 
on khach_hang.id_khach_hang=hop_dong.id_khach_hang
where khach_hang.id_loai_khach=1
group by khach_hang.ho_ten
order by count(khach_hang.id_khach_hang) asc;

/*5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu,
 NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: 
 ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các
 Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
select khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach,
       hop_dong.id_hop_dong,dich_vu.ten_dich_vu, hop_dong.ngay_ky_hop_dong,
       hop_dong.ngay_ket_thuc, dich_vu.chi_phi_thue + (dich_vu_di_kem.don_vi*dich_vu_di_kem.gia)
       as 'tổng số tiền'
from khach_hang
	left join loai_khach 
	on loai_khach.id_loai_khach = khach_hang.id_loai_khach
	left join hop_dong 
	on khach_hang.id_khach_hang = hop_dong.id_khach_hang
	left join dich_vu
	on dich_vu.id_dich_vu = hop_dong.id_dich_vu
	left join hop_dong_chi_tiet 
	on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	left join dich_vu_di_kem 
	on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem;
 
 /*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ
 chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/
select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.chi_phi_thue,
        loai_dich_vu.ten_loai_dich_vu
from dich_vu
	left join loai_dich_vu 
	on loai_dich_vu.id_loai_dich_vu =dich_vu.id_loai_dich_vu
	left join hop_dong 
	on hop_dong.id_dich_vu =dich_vu.id_dich_vu
	where hop_dong.ngay_ky_hop_dong <> ('2019/01/%' 
									   and '2019/02/%'
									   and '2019/03/%');
/*7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
 của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.*/
 
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, 
        dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
	left join loai_dich_vu 
	on loai_dich_vu.id_loai_dich_vu =dich_vu.id_loai_dich_vu
	left join hop_dong 
	on hop_dong.id_dich_vu =dich_vu.id_dich_vu 
	where (hop_dong.ngay_ky_hop_dong like '2018%' )  
		   and hop_dong.ngay_ky_hop_dong not in (
           select hop_dong.ngay_ky_hop_dong 
           from hop_dong
           where hop_dong.ngay_ky_hop_dong like '2019%');

/*8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên */
-- cách 1
select distinct khach_hang.ho_ten
from khach_hang;
-- cách 2
select khach_hang.ho_ten
from khach_hang
group by khach_hang.ho_ten;
-- cách 3 (chưa nghĩ ra -_-)
select khach_hang.ho_ten
from khach_hang
union
select khach_hang.ho_ten
from khach_hang;
/* 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng
 trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/
 select substr(hop_dong.ngay_ky_hop_dong,6,2) as thang_2019 ,count(hop_dong.id_khach_hang) as so_lan_dat
 from hop_dong
 where hop_dong.ngay_ky_hop_dong like '2019%'
 group by substr(hop_dong.ngay_ky_hop_dong,6,2);
 
 /*10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả 
 hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
 (được tính dựa trên việc count các IDHopDongChiTiet).*/
 
 select hop_dong.id_hop_dong,hop_dong.ngay_ky_hop_dong,hop_dong.ngay_ket_thuc,hop_dong.tien_dat_coc,hop_dong_chi_tiet.so_luong
 from hop_dong
 left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong;
 
 /*11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
 TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
select  khach_hang.ho_ten, dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,
        dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trang_thai_kha_dung
from dich_vu_di_kem
    left join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
	left join hop_dong on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	left join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
	left join loai_khach on loai_khach.id_loai_khach= khach_hang.id_loai_khach
	where loai_khach.id_loai_khach = 1
		and (khach_hang.dia_chi = 'Vinh'
		or khach_hang.dia_chi = 'Quảng Ngãi') 
	group by khach_hang.ho_ten;
    
/*12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu,
 SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ
 đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/ 

select hop_dong.id_hop_dong, nhan_vien.ho_ten as nhan_vien, khach_hang.ho_ten as khach_hang, khach_hang.sdt, 
       dich_vu.ten_dich_vu, hop_dong.ngay_ky_hop_dong, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as SoLuongDichVuDikem
from hop_dong
left join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
left join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
where (hop_dong.ngay_ky_hop_dong >='2019/10/01' and hop_dong.ngay_ky_hop_dong <='2019/12/31' ) 
	and hop_dong.ngay_ky_hop_dong not in (
    select hop_dong.ngay_ky_hop_dong
    from hop_dong
    where
    hop_dong.ngay_ky_hop_dong between '2019/01/01' and '2019/06/31')
group by hop_dong.id_hop_dong;

/*13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng 
đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau). */
create or replace view so_luong as
select  dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,
        dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trang_thai_kha_dung,count(dich_vu_di_kem.ten_dich_vu_di_kem) as so_luong1
from dich_vu_di_kem
left join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
left join hop_dong on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
left join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
group by dich_vu_di_kem.ten_dich_vu_di_kem;

select *
from so_luong
where so_luong.so_luong1 = (select max(so_luong.so_luong1) from so_luong);

/* 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
 Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
 
 select hop_dong.id_hop_dong ,loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_luong
 from hop_dong_chi_tiet
 inner join hop_dong on hop_dong.id_hop_dong=hop_dong_chi_tiet.id_hop_dong
 inner join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
 inner join dich_vu on hop_dong.id_dich_vu=dich_vu.id_dich_vu
 inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu=dich_vu.id_loai_dich_vu
 group by hop_dong_chi_tiet.id_dich_vu_di_kem
 having so_luong=1;
 
/*15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, 
SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
select nhan_vien.id_nhan_vien,nhan_vien.ho_ten ,trinh_do.trinh_do,bo_phan.ten_bo_phan,nhan_vien.sdt,nhan_vien.dia_chi
from hop_dong
inner join nhan_vien on hop_dong.id_nhan_vien=nhan_vien.id_nhan_vien
inner join trinh_do on trinh_do.id_trinh_do=nhan_vien.id_trinh_do
inner join bo_phan on bo_phan.id_bo_phan=nhan_vien.id_bo_phan
where year(hop_dong.ngay_ky_hop_dong) in (2018,2019)
group by nhan_vien.id_nhan_vien
having count(hop_dong.id_hop_dong)<4;

/*16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.*/
delete nhan_vien
from nhan_vien
	left join hop_dong on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
where nhan_vien.id_nhan_vien not in 
	(select hop_dong.id_nhan_vien from hop_dong where
	(year(hop_dong.ngay_ky_hop_dong) in (2017,2018,2019)));
select *
from nhan_vien;
select *
from hop_dong;

/*17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
 chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ*/
 
update khach_hang
set id_loai_khach =1
where id_khach_hang in
(select khach_hang.id_khach_hang 
    from 
   (select khach_hang.id_khach_hang
		  from khach_hang 
		  inner join hop_dong on khach_hang.id_khach_hang=hop_dong.id_khach_hang
          where khach_hang.id_loai_khach=3 and year(hop_dong.ngay_ky_hop_dong) in (2019)
		  group by khach_hang.id_khach_hang
		  having sum(hop_dong.tong_tien)>=10000000) as temp);

/*18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).*/

delete khach_hang
from khach_hang 
where khach_hang.id_khach_hang in (
   select id_khach_hang
   from (
      select khach_hang.id_khach_hang
      from khach_hang
      inner join hop_dong on khach_hang.id_khach_hang=hop_dong.id_khach_hang
      where year(hop_dong.ngay_ky_hop_dong) <'2016' and (hop_dong.id_khach_hang not in  
		  (select id_khach_hang
		  from hop_dong
		  where year(hop_dong.ngay_ky_hop_dong) >='2016'))) as temp);

select *
from khach_hang ;

/*19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 5 lần trong năm 2019 lên gấp đôi.*/
update dich_vu_di_kem
set gia = gia*2
where dich_vu_di_kem.id_dich_vu_di_kem in (
	select id_dich_vu_di_kem
	from (
		select dich_vu_di_kem.id_dich_vu_di_kem
		from dich_vu_di_kem
		inner join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem= hop_dong_chi_tiet.id_dich_vu_di_kem
        inner join hop_dong on hop_dong.id_hop_dong=hop_dong_chi_tiet.id_hop_dong
        where hop_dong.ngay_ky_hop_dong
		group by dich_vu_di_kem.id_dich_vu_di_kem
		having count(dich_vu_di_kem.id_dich_vu_di_kem)>5) as temp);
select*
from dich_vu_di_kem;
/*20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị 
bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/

select id_nhan_vien,nhan_vien.ho_ten as ho_ten_nhan_vien ,email as email_nhan_vien ,sdt as sdt_nhan_vien,ngay_sinh as ngay_sinh_nhan_vien ,
       dia_chi as dia_chi_nhan_vien 
 from nhan_vien
 union
 select id_khach_hang,ho_ten as ho_ten_khach_hang,email as email_khach_hang,sdt as sdt_khach_hang,ngay_sinh as ngay_sinh_khach_hang,
        dia_chi as dia_chi_khach_hang
from khach_hang
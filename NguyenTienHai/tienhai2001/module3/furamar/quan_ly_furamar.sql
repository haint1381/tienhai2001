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
	references vi_tri(id_vi_tri),
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
    references loai_dich_vu(id_loai_dich_vu),
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
    references nhan_vien(id_nhan_vien),
	foreign key(id_khach_hang) 
    references khach_hang(id_khach_hang),
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
    references hop_dong(id_hop_dong)
);
/*1.	Thêm mới thông tin cho tất cả các bảng có trong 
CSDL để có thể thõa mãn các yêu cầu bên dưới.*/

insert into vi_tri 
values
	(1,'Giám Đốc'),
	(2,'Giám sát'),
	(3,'Lễ Tân'),
	(4,'Phục vụ'),
	(5,'Quản lý');
insert into trinh_do 
values
	(1,'Cao đẳng'),
	(2,'Đại học'),
	(3,'Cao đẳng'),
	(4,'Sau đại học'),
	(5,'Trung cấp');
insert into bo_phan 
values 
	(1,'Sale – Marketing'),
	(2,'Hành Chính'),
	(3,'Quản lý'),
	(4,'Phục vụ'),
	(5,'Quản lý');
insert into nhan_vien 
values
    (1,'Nguyễn Tiến Hải',1,1,1,'2001/08/13','123415678',8000000,'0394772917','tienhai@gmail.com','hà tĩnh'),
    (2,'Lê Nhật',2,2,2,'2000/01/01','123415677',2000000,'0394772917','lenhat@gmail.com','quảng trị'),
    (3,'Trần Thanh Hoàng',3,3,3,'1999/01/01','123415676',7000000,'0394772917','thanhhoang@gmail.com','vô gia cư'),
    (4,'Hữu Quang',4,4,4,'1996/01/01','123451675',5000000,'0394772917','huuquang@gmail.com','đà nẵng'),
    (5,'Lê Toàn',1,1,1,'1993/01/01','123451674',9000000,'0394772917','letoan@gmail.com','đà nẵng');
insert into loai_khach
values
	(1,'Diamond'),
	(2,'Gold'),
	(3,'Platinium'),
	(4,'Silver'),
	(5,'Member');
insert into khach_hang
values
    (1,1,'Văn Chương','1988/01/01','876543211','0394772917','vanchuong@gmail.com','đà nẵng'),
    (2,2,'Quốc Khánh','1993/01/01','876514312','0394772917','quockhanh@gmail.com','nghệ an'),
    (3,3,'Trần Đạt','1992/01/01',879761542,'0394772917','trandat@gmail.com','đà nẵng'),
    (4,4,'Sơn Trà','1995/01/01',098765432,'0394772917','sontra@gmail.com','quảng Trị'),
    (5,5,'Hữu Hiên','1994/01/01',123876549,'0394772917','huuhien@gmai.com','phú yên');
insert into kieu_thue
values
    (1,'thuê theo ngày',500000),
    (2,'thuê theo tuần',100000),
    (3,'thuê theo tháng',900000),
    (4,'thuê theo ngày',300000),
    (5,'thuê theo tuần',100000);
insert into loai_dich_vu
values
    (1,'villa'),
    (2,'house'),
    (3,'room'),
    (4,'villa'),
    (5,'room');
insert into dich_vu
values
    (1,'villa',300,2,5,400000,1,1,'mới'),
    (5,'villa',400,3,5,600000,5,5,'cũ'),
    (2,'house',200,3,6,300000,2,2,'mới'),
    (3,'room',100,1,3,200000,3,3,'cũ'),
    (4,'room',150,3,3,300000,4,4,'mới');
insert into hop_dong
values
	(1,1,1,1,'2020/08/20','2020/09/20',1000000,5000000),
	(2,2,2,2,'2020/01/20','2020/01/27',3000000,6000000),
	(3,3,3,3,'2020/02/20','2020/02/27',2000000,4000000),
	(4,4,4,4,'2020/08/20','2020/08/21',100000,1000000),
	(5,5,5,5,'2020/09/20','2020/10/20',2000000,5000000);
insert into dich_vu_di_kem
values
	(1,'massage',100000,4,'tốt'),
	(2,'karaoke',250000,9,'tốt'),
	(3,'thức ăn',200000,7,'tốt'),
	(4,'nước uống',10000,4,'tốt'),
	(5,'tham quan',500000,5,'tốt');
insert into hop_dong_chi_tiet
values
	(1,1,1,3),
	(2,2,2,9),
	(3,3,3,6),
	(4,4,4,5),
	(5,5,5,2);
    
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
where khach_hang.id_khach_hang=1
group by khach_hang.ho_ten
order by count(khach_hang.id_khach_hang) asc;
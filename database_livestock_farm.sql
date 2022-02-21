use livestock_farm;
INSERT INTO `livestock_farm`.`roles` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `livestock_farm`.`roles` (`id`, `name`) VALUES ('2', 'ROLE_EMPLOYEE');
INSERT INTO `livestock_farm`.`roles` (`id`, `name`) VALUES ('3', 'ROLE_CUSTOMER');
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('06a7978d-ad4a-4b96-95d2-271bd641caa9', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'nhanvien1', null);
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('08459377-63c5-4794-b69c-f665ecf00c8a', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'nhanvien2', null);
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('159c674c-d64c-4649-abc0-68564e05dfa0', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'admin1', null);
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('17bab4b8-c4cd-44f4-a86a-1cd50cfa4925', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'admin2', null);
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('96d4d3a6-8803-11ec-a8a3-0242ac120002', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'abc123', null);
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('ae9256bc-8803-11ec-a8a3-0242ac120002', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'vip123', null);
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('b3b25ee4-8803-11ec-a8a3-0242ac120002', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'vippro', null);
INSERT INTO `livestock_farm`.`app_users` (`id`, `deleted`, `is_enabled`, `password`, `username`, `verification_code`) VALUES ('bac98b30-8803-11ec-a8a3-0242ac120002', 0, 1, '$2a$12$.Mfx0vhTiWRZL723RZD4.uROZM6QVKpYJ4ZM.JSuc54IJVMz7rJAi', 'vipvip', null);
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('06a7978d-ad4a-4b96-95d2-271bd641caa9', '2');
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('08459377-63c5-4794-b69c-f665ecf00c8a', '2');
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('159c674c-d64c-4649-abc0-68564e05dfa0', '1');
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('17bab4b8-c4cd-44f4-a86a-1cd50cfa4925', '1');
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('96d4d3a6-8803-11ec-a8a3-0242ac120002', '1');
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('ae9256bc-8803-11ec-a8a3-0242ac120002', '2');
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('b3b25ee4-8803-11ec-a8a3-0242ac120002', '2');
INSERT INTO `livestock_farm`.`app_users_roles` (`app_users_id`, `roles_id`) VALUES ('bac98b30-8803-11ec-a8a3-0242ac120002', '1');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1001', 'Da Nang', '1991-1-1', 0, 'nguyena@gmail.com', 1, '123456710', 'Nguyen Van Nam', '0901234567', '06a7978d-ad4a-4b96-95d2-271bd641caa9');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1002', 'Quang Nam', '1991-2-1', 0, 'nguyenb@gmail.com', 1, '123456711', 'Nguyen Hữu Thắng', '0901234567', '08459377-63c5-4794-b69c-f665ecf00c8a');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`)
 VALUES ('NV-1003', 'Ha Noi', '1992-1-14', 0, 'nguyenc@gmail.com', 0, '123456712', 'Nguyen Như Ngọc', '0901234567', '159c674c-d64c-4649-abc0-68564e05dfa0');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1004', 'Ho Chi Minh', '1993-1-11', 0, 'nguyend@gmail.com', 1, '123456713', 'Lê Bá Thiện', '0901234567', '17bab4b8-c4cd-44f4-a86a-1cd50cfa4925');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`)
 VALUES ('NV-1005', 'Ho Chi Minh', '1992-1-12', 0, 'trand@gmail.com', 1, '123456714', 'Tran Văn Tài', '0901234567', '96d4d3a6-8803-11ec-a8a3-0242ac120002');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`)
 VALUES ('NV-1006', 'Ho Chi Minh', '1994-1-1', 0, 'led@gmail.com', 0, '123456715', 'Huỳnh Hải Hà', '0901234567', 'ae9256bc-8803-11ec-a8a3-0242ac120002');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`)
 VALUES ('NV-1007', 'Da Nang', '1993-1-14', 0, 'nguyen123@gmail.com', 0, '123456716', 'Nguyen Nam Trân', '0901234567', 'b3b25ee4-8803-11ec-a8a3-0242ac120002');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1008', 'Da Nang', '1996-3-1', 0, 'hovand@gmail.com', 1, '123456717', 'Lê Thanh Tùng', '0901234567', 'bac98b30-8803-11ec-a8a3-0242ac120002');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1012', 'Da Nang', '1996-3-1', 0, 'hovand@gmail.com', 1, '123456718', 'Hoàng Thanh Hải', '0901234567', 'bac98b30-8803-11ec-a8a3-0242ac120002');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1009', 'Da Nang', '1996-3-1', 0, 'hovand@gmail.com', 1, '123456719', 'Nguyễn Thanh Hải', '0901234567', 'bac98b30-8803-11ec-a8a3-0242ac120002');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1010', 'Da Nang', '1996-3-1', 0, 'hovand@gmail.com', 1, '123456720', 'Lê Thanh Đạt', '0901234567', 'bac98b30-8803-11ec-a8a3-0242ac120002');
INSERT INTO `livestock_farm`.`employees` (`id`, `address`, `date_of_birth`, `deleted`, `email`, `gender`, `id_card`, `name`, `phone_number`, `app_user_id`) 
VALUES ('NV-1011', 'Da Nang', '1996-3-1', 0, 'hovand@gmail.com', 1, '123456724', 'Hà Tú Anh', '0901234567', 'bac98b30-8803-11ec-a8a3-0242ac120002');

insert into type_of_news value (1, 'Chăn nuôi'),(2, 'Công nghệ');
insert into news value
(1,
'Sở Nông nghiệp và Phát triển nông thôn Lâm Đồng cho biết, phấn đấu đến cuối năm 2022 đạt tổng số lượng 900 trang trại phát triển sản xuất, chăn nuôi trên địa bàn.
Theo đó, mỗi địa bàn cấp huyện xây dựng 4 - 5 mô hình trang trại điển hình liên kết sản xuất gắn với tiêu thụ sản phẩm, đảm bảo các tiêu chí về vệ sinh môi trường, đạt doanh thu bình quân 3 tỷ đồng/trang trại/năm.
Được biết, đến đầu năm 2022, toàn tỉnh Lâm Đồng có 730 trang trại đang duy trì và phát triển hoạt động sản xuất, kinh doanh, gồm chăn nuôi (458 trang trại), trồng trọt (242 trang trại), tổng hợp (29 trang trại), thủy sản (1 trang trại).',
0,'https://nguoichannuoi.vn/images/news/2022/01/21/medium/trang-trai-heo_1642736160.jpg','2022-01-22',
'Lâm Đồng: Phát triển 900 trang trại vào cuối năm 2022','NV-1005',1),
(2,
'Cuối năm là dịp cao điểm của hoạt động mua bán, vận chuyển và giết mổ gia súc, gia cầm, cũng là lúc có nguy cơ cao lây bệnh trên đàn vật nuôi. Trước tình hình đó, Chi cục Chăn nuôi và Thú y (Sở NN&PTNT) tăng cường phối hợp với các địa phương thực hiện các biện pháp phòng chống dịch, tăng cường tiêm vắc xin cho đàn vật nuôi.
Đến thời điểm hiện tại, theo đánh giá của ngành Nông nghiệp tỉnh, dịch bệnh trên đàn vật nuôi cơ bản được kiểm soát. Tuy nhiên, trong bối cảnh dịch bệnh bùng phát trở lại ở một số địa phương trong cả nước, nguy cơ dịch bệnh xuất hiện trên địa bàn tỉnh rất cao. Trước tình hình này, Chi cục Chăn nuôi và Thú y tổ chức xây dựng và triển khai kế hoạch giám sát, khoanh vùng, thu thập các mẫu của vật nuôi, xét nghiệm xác định nguyên nhân, kịp thời cảnh báo.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/tiem-phong-vat-nuoi.jpg','2022-01-22',
'Bình Định: Tập trung phòng dịch cho đàn vật nuôi','NV-1004',1),
(3,
'Sau Tết, các trang trại, hộ chăn nuôi trên địa bàn tỉnh rục rịch tái đàn để duy trì quy mô chăn nuôi, ổn định sản xuất, bảo đảm nguồn cung thực phẩm, đáp ứng nhu cầu thị trường. Trước tình hình dịch bệnh trên đàn gia súc gia cầm (GSGC) vẫn còn diễn biến phức tạp, nhiều hộ chăn nuôi đã chủ động các biện pháp tiêu độc khử trùng chuồng trại, tiêm nhắc lại vắc xin, bổ sung vitamin… để nâng cao sức đề kháng cho đàn vật nuôi trước khi tái đàn.
Toàn tỉnh hiện có 17,6 nghìn con trâu; hơn 103,6 nghìn con bò; 466,2 nghìn con lợn nái, tăng 3,64% và hơn 12 triệu con gia cầm. Sau Tết, tại nhiều nơi chăn nuôi quy mô lớn của tỉnh như Hoàng Hoa (Tam Dương), Thanh Vân (Tam Dương), Quang Sơn (Lập Thạch)… người chăn nuôi đang rục rịch tái đàn để khôi phục sản xuất, duy trì quy mô và ổn định đàn vật nuôi.
Tại gia đình chị Nguyễn Thị Liên, thôn 12, xã Hoàng Hoa (Tam Dương) những ngày này, công tác tiêu độc, khử trùng chuồng trại đang được chị và các thành viên trong gia đình tập trung triển khai để chuẩn bị vào lứa gà đẻ mới, thay thế cho lứa gà cũ sau 1 năm chăn nuôi.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/tai%20dan%20sau%20tet.jpg','2022-02-01',
'Vĩnh Phúc: Chủ động tái đàn vật nuôi sau Tết','NV-1001',1),
(4,
'(Người Chăn Nuôi) - Xung quanh câu chuyện chuyển đổi số ngành chăn nuôi, Cục trưởng Cục Chăn nuôi Dương Tất Thắng (ảnh) chia sẻ: “Chuyển đổi số là công cuộc chung, doanh nghiệp, người dân và cơ quan Nhà nước cùng tham gia thực hiện. Cục Chăn nuôi sẽ thực hiện với phương châm: Lắng nghe, chia sẻ, phối hợp hiệu quả nhất với doanh nghiệp; Chủ động, đồng hành và hỗ trợ thiết thực với người chăn nuôi”.
Ông có thể cho biết vì sao phải thực hiện chuyển đổi số đối với ngành chăn nuôi?
Chúng ta đang bước vào kỷ nguyên số, kỷ nguyên để phát triển nền kinh tế gắn với việc ứng dụng công nghệ thông tin và khai thác dữ liệu phục vụ công tác quản lý, sản xuất và kinh doanh. Ngành chăn nuôi là một ngành kinh tế kỹ thuật cũng không thể nằm ngoài xu hướng phát triển này. Theo tôi, chuyển đổi số ngành chăn nuôi bắt buộc phải thực hiện vì 2 lý do. Thứ nhất, đây là yêu cầu trong việc thực thi pháp luật và công tác quản lý ngành. Ngày 3/6/2020, Thủ tướng Chính phủ đã phê duyệt Quyết định số 749/QĐ-TTg về “Chương trình Chuyển đổi số quốc gia đến năm 2025, định hướng đến năm 2030. Chương trình Chuyển đổi số quốc gia nhằm mục tiêu vừa phát triển Chính phủ số, kinh tế số, xã hội số, vừa hình thành các doanh nghiệp công nghệ số Việt Nam có năng lực đi ra toàn cầu. Đối với ngành chăn nuôi, hệ thống văn bản quy phạm pháp luật để quản lý, bao gồm Luật Chăn nuôi, 2 Nghị định và 5 Thông tư để quản lý ngành, trong đó Thông tư số 20/2019/TT-BNNPTNT quy định về việc cập nhật, khai thác và quản lý cơ sở dữ liệu về chăn nuôi và Thông tư số 23/2019/TT-BNNPTNT yêu cầu tổ chức, cá nhân chăn nuôi phải kê khai hoạt động chăn nuôi. Để thực hiện được công tác khai báo và cập nhật dữ liệu cơ sở chăn nuôi cần phải xây dựng hệ thống cơ sở dữ liệu về chăn nuôi, đây là một trong những nhiệm vụ của chương trình chuyển đổi số của ngành chăn nuôi trong giai đoạn hiện nay.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/ong-duong-tat-thang.jpg','2022-02-02',
'Chuyển đổi số, chìa khóa để chăn nuôi bứt phá','NV-1002',2),
(5,
'(Người Chăn Nuôi) - Bước sang năm 2022, ngành chăn nuôi Việt nam đề ra mục tiêu, tăng trưởng giá trị sản xuất bình quân đạt khoảng 4 - 5%. Sản lượng thịt các loại đạt khoảng 6,44 triệu tấn, tăng khoảng 4%.
2021 - Hơn cả mong đợi
Ngày 29/12, Bộ NN&PTNT tổ chức Hội nghị Tổng kết ngành nông nghiệp năm 2021 và triển khai kế hoạch năm 2022. Hội nghị được tổ chức bằng hình thức trực tiếp tại điểm cầu chính Hà Nội và trực tuyến tới nhiều đơn vị trực thuộc Bộ NN&PTNT. Thủ tướng Phạm Minh Chính tới dự và chỉ đạo Hội nghị.
Năm 2021, ngành nông nghiệp triển khai thực hiện kế hoạch năm 2021 trong điều kiện có những thuận lợi và khó khăn àan xen. Vûúåt qua nhûäng thaách thûác, ngaânh nöng nghiïåp àaä vï đích ngoạn mục, nổi bật nhất là giá trị xuất khẩu nông, lâm, thủy sản ước đạt khoảng 48,6 tỷ USD, vượt xa mục tiêu 42 tỷ USD mà Chính phủ đưa ra.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/chan-nuoi-2022.jpg','2022-02-03',
'2022: “Chuyển mình” thích ứng','NV-1001',2),
(6,
'(Người Chăn Nuôi) - Ngành chăn nuôi Việt Nam năm 2021 đã phải đối mặt với nhiều khó khăn chưa từng có. Triển vọng năm 2022 liệu có sáng sủa, tích cực hơn? Và đâu sẽ là những cơ hội, thách thức của ngành?
Theo dự báo của nhiều chuyên gia, thị trường chăn nuôi toàn cầu sẽ tăng trở lại vào nửa sau của năm 2022 do các nước cơ bản đã khống chế được dịch, thực hiện chính sách mở cửa an toàn, sống chung với dịch. Nếu dự báo này đúng, chuỗi cung ứng thức ăn chăn nuôi (TĂCN) và sản phẩm chăn nuôi sẽ dần trở lại như trước khi có dịch, giúp giá thức ăn xuống thấp theo đúng giá trị, chi phí vận chuyển hàng hóa giảm, nguồn lao động ngành chăn nuôi dồi dào… có thể nói đây là cơ hội lớn nhất, quan trọng nhất của ngành chăn nuôi toàn cầu nói chung và ngành chăn nuôi Việt Nam nói riêng trong năm 2022.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/chan-nuoi-2022(1).jpg','2022-02-04',
'Chăn nuôi Việt Nam năm 2022: 3 cơ hội, 4 thách thức','NV-1003',2),
(7,
'Cục Chăn nuôi (Bộ Nông nghiệp và Phát triển nông thôn) cho biết, năm 2021, đàn gia súc, gia cầm của cả nước phát triển khá tốt, trong đó gia cầm đạt khoảng 525 triệu con, tăng 5,8% so với năm 2020. Tuy nhiên, có ý kiến cho rằng, do ảnh hưởng của dịch Covid-19, dịch bệnh trên đàn vật nuôi, cho nên năm 2022 ngành chăn nuôi gia cầm vẫn phải đối mặt với nhiều thách thức. Vì vậy, để vượt qua những khó khăn, thách thức này cần thực hiện đồng bộ nhiều giải pháp hữu hiệu.
Theo Cục Thú y, năm 2021, dịch bệnh trên động vật tiềm ẩn nhiều nguy cơ bùng phát, đã xuất hiện một số chủng vi-rút có độc lực cao trên đàn gia cầm (A/H5N6, A/H5N1, A/H5N8), trong đó chủng A/H5N8 lần đầu xâm nhiễm vào Việt Nam, buộc phải tiêu hủy 450 nghìn con gia cầm (tăng gấp hơn 2 lần so với năm 2020).',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/cham%20soc%20ga.jpg','2022-02-05',
'Thách thức mới của ngành chăn nuôi gia cầm','NV-1004',1),
(8,
'(Người Chăn Nuôi) - Trước đây, nhiều sinh viên học chăn nuôi, thú y khi mới ra trường thường phải chọn làm "trái tay". Nay, họ được các công ty, phòng khám "trải thảm" mời về, trả lương cao, lại còn được đào tạo lại. "Bác sĩ thú y" đang là từ khóa được tìm nhiều nhất trong các ngành học liên quan nông nghiệp, trên các trang tìm kiếm hiện nay.
Mấy tuần qua, chị TN cố gắng thông qua mọi kênh giới thiệu việc làm, bạn bè và những hội nhóm trên mạng xã hội để đăng tin tuyển dụng bác sĩ thú y. Mức lương cho vị trí này không thấp hơn 20 triệu đồng/tháng và vị trí này sẽ có việc làm ngay sau buổi phỏng vấn đạt yêu cầu. Chị TN cho biết, yêu cầu đặt ra cho vị trí bác sĩ thú y là phải giỏi tiếng Anh, vì sẽ phải bay sang Australia, New Zealand trực tiếp tuyển chọn những con bò giống đạt chất lượng trước khi nhập về Việt Nam.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/z300-Nguoi-chan-nuoi-55-.jpg','2022-02-06',
'Rầm rộ tìm lao động thú y, chăn nuôi trình độ cao','NV-1001',2),
(9,
'Nhằm nâng cao năng suất, chất lượng đàn gia súc, thời gian qua, ngành nông nghiệp và các địa phương trong tỉnh đã tập trung đẩy mạnh việc áp dụng các tiến bộ khoa học kỹ thuật vào chăn nuôi để tạo ra những con vật lai có tầm vóc, thể trạng tốt. Nhiều mô hình chăn nuôi quy mô hàng hóa được hình thành, góp phần nâng cao thu nhập cho người dân.
Chăn nuôi được xác định là một trong những thế mạnh của huyện Vĩnh Linh nhưng theo đánh giá, việc phát triển đàn trâu, bò thời gian qua chưa tương xứng với tiềm năng, lợi thế của địa phương. Nguyên nhân là do đa số các hộ chăn nuôi theo hình thức nhỏ lẻ. Việc ứng dụng khoa học kỹ thuật (KHKT) còn hạn chế, chăn thả tự do nên xảy ra hiện tượng giao phối cận huyết làm giảm tầm vóc và sức sản xuất của vật nuôi, dẫn đến hiệu quả kinh tế chưa cao. Nhằm nâng cao thể trọng, tầm vóc đàn gia súc của địa phương, huyện Vĩnh Linh đã chỉ đạo các cơ quan chuyên môn triển khai đồng bộ các giải pháp nhằm thúc đẩy ngành chăn nuôi phát triển.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/dan-bo-lai.jpg','2022-02-07',
'Quảng Trị: Áp dụng khoa học kỹ thuật nâng cao tầm vóc, chất lượng đàn gia súc','NV-1005',2),
(10,
'Từ điều kiện địa lý, Hà Nội có tiềm năng, lợi thế phát triển chăn nuôi bò thịt, bò sữa. Thời gian qua, nhiều địa phương trên địa bàn thành phố đã đưa giống bò mới vào sản xuất, đạt hiệu quả cao. Tuy nhiên, để chăn nuôi bò phát triển bền vững, các địa phương, đơn vị còn nhiều việc phải làm.
Bà Trương Thị Kiểm ở xã Vân Hòa (huyện Ba Vì) cho biết, gia đình bà đang nuôi 6 con bò sữa, bán được sữa với giá bình quân 11.000 - 14.000 đồng/lít. Chăn nuôi bò sữa vất vả nhưng ổn định, không biến động như chăn nuôi lợn, gà... Còn hộ ông Đặng Đình Hậu ở xã Lam Điền (huyện Chương Mỹ) đang nuôi tổng đàn khoảng 100 con bò thịt giống BBB. Đây là giống bò cho năng suất, chất lượng cao, doanh thu đạt khoảng 700 triệu đồng/năm, trừ các khoản chi phí, lãi 350 triệu đồng/năm. “Nếu như trước đây, bò thịt truyền thống cho lãi 5 - 6 triệu đồng/năm thì các giống bò lai cho lãi 8 - 10 triệu đồng/con”, ông Hậu chia sẻ.',
0,'https://nguoichannuoi.vn/upload_images/images/nha-nong-lam-giau/nuoi-bo-sua-ba-vi.jpg','2022-02-09',
'Hà Nội: Tập trung phát triển bò thịt, bò sữa','NV-1006',1),
(11,
'Để chủ động tổ chức kiểm soát tốt, không để các loại dịch bệnh nguy hiểm xảy ra diện rộng, bảo đảm nguồn cung thực phẩm, bảo đảm an toàn thực phẩm trong thời gian trước, trong và sau Tết Nguyên đán Nhâm Dần 2022, Sở Nông nghiệp và Phát triển nông thôn đã có văn bản đề nghị các huyện, thị xã, thành phố tập trung các nguồn lực và khẩn trương triển khai quyết liệt, đồng bộ các biện pháp phòng, chống dịch bệnh.
Theo thông tin cập nhật từ Hệ thống quản lý dịch bệnh động vật Việt Nam (VAHIS) - Cục Thú y, tình hình dịch bệnh gia súc, gia cầm đang diễn biến rất phức tạp, đặc biệt là các bệnh Dịch tả lợn Châu Phi, bệnh VDNC trâu bò, bệnh Cúm gia cầm; tại tỉnh ta mặc dù dịch bệnh trên đàn gia súc, gia cầm, động vật thủy sản cơ bản đã được kiểm soát hiệu quả. Tuy nhiên, nhận định nguy cơ các loại dịch bệnh nguy hiểm trên trên đàn vật nuôi vào đầu năm 2022 (vụ Đông Xuân) là rất cao, do một số nguyên nhân như sau: Tổng đàn vật nuôi, mật độ chăn nuôi tăng cao, trong đó chăn nuôi nhỏ lẻ vẫn chiếm tỷ trọng lớn, các biện pháp chăn nuôi an toàn sinh học, vệ sinh, sát trùng phòng bệnh còn hạn chế ở nhiều nơi. Các hoạt động buôn bán, vận chuyển, giết mổ động vật tăng mạnh để phục vụ nhu cầu trong thời gian trước, trong và sau Tết Nhâm Dần. Các loại mầm bệnh nguy hiểm tồn tại trong môi trường nhiều, khi gặp điều kiện thuận lợi sẽ xâm nhập gây bệnh, đặc biệt là vi rút gây bệnh DTLCP, VDNC trâu bò, nhất là các chủng Cúm gia cầm có tỷ lệ lưu hành rất cao (tỷ lệ lưu hành vi rút cúm A/H5N6, A/H5N8 trên địa bàn tỉnh năm 2021 là 5,25%). Đặc biệt thời tiết thay đổi chuyển mùa, làm giảm sức đề kháng của đàn vật nuôi và tạo thuận lợi cho mầm bệnh tồn tại, phát tán diện rộng và gây ra dịch bệnh.',
0,'https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/tiem-cho-ga-th-1.jpg','2022-02-10',
'Thanh Hóa: Triển khai các biện pháp phòng, chống dịch bệnh động vật trước, trong và sau Tết Nguyên đán Nhâm Dần 2022','NV-1002',1)

;
--  select n.id, n.content, n.title, n.image, n.post_date, n.employee_id, n.type_of_news_id 
-- 		from news n 
--         join employees e on n.employee_id = e.id
-- 		join type_of_news t on n.type_of_news_id = t.id 
-- 		where (title like  concat('%',trim(''),'%')
--         or e.`name` like  concat('%',trim('Đạt'),'%')
-- 		or t.`name` like  concat('%',trim(''),'%'))
--         and deleted =false
insert into type_of_cage values(1,'Heo'), (2,'Gà'),(3,'Vịt'),(4,'Bò'),(5,'Dê');
insert into cages values('CA-1000','2021-01-10',0,'2021-12-15',100,'NV-1001',1),
('CA-1001','2021-01-10',0,'2021-12-15',100,'NV-1001',1),
('CA-1002','2021-02-10',0,'2022-01-15',100,'NV-1001',1),
('CA-1003','2021-02-15',0,'2021-12-20',100,'NV-1002',1),
('CA-1004','2021-03-12',0,'2021-11-22',100,'NV-1003',2),
('CA-1005','2021-02-11',0,'2021-10-13',100,'NV-1004',2),
('CA-1006','2021-01-03',0,'2021-12-09',100,'NV-1005',2),
('CA-1007','2021-01-05',0,'2021-10-19',100,'NV-1006',3),
('CA-1008','2021-02-08',0,'2021-09-15',100,'NV-1007',3),
('CA-1009','2021-03-14',0,'2021-12-28',100,'NV-1008',3),
('CA-1010','2021-01-11',0,'2021-12-26',100,'NV-1009',4),
('CA-1011','2021-04-17',0,'2021-11-18',100,'NV-1010',4),
('CA-1012','2021-01-14',0,'2021-10-11',100,'NV-1011',4),
('CA-1013','2021-03-21',0,'2021-12-29',100,'NV-1012',5),
('CA-1014','2021-02-08',0,'2021-11-09',100,'NV-1001',5),
('CA-1015','2021-02-13',0,'2021-11-23',100,'NV-1002',5);
insert into individuals(id,cage_id,date_in,date_out,`status`,weight,deleted) values('IN-1000','CA-1000','2021-01-11','2021-12-01',0,50.5,0),
('IN-1001','CA-1001','2021-01-11','2021-12-01',0,52.3,0),
('IN-1002','CA-1002','2021-01-11','2021-12-01',1,51.2,0),
('IN-1003','CA-1003','2021-01-11','2021-12-01',0,50.2,0),
('IN-1004','CA-1004','2021-01-11','2021-12-01',1,53.4,0),
('IN-1005','CA-1005','2021-01-11','2021-12-01',0,49.5,0),
('IN-1006','CA-1006','2021-01-11','2021-12-01',1,49.1,0),
('IN-1007','CA-1007','2021-01-11','2021-12-01',0,52.2,0),
('IN-1008','CA-1008','2021-01-11','2021-12-01',1,50.8,0),
('IN-1009','CA-1009','2021-01-11','2021-12-01',0,49.9,0),
('IN-1010','CA-1010','2021-01-11','2021-12-01',1,48.2,0),
('IN-1011','CA-1011','2021-01-11','2021-12-01',0,47.3,0),
('IN-1012','CA-1012','2021-01-11','2021-12-01',1,48.5,0),
('IN-1013','CA-1013','2021-01-11','2021-12-01',0,50.5,0),
('IN-1014','CA-1014','2021-01-11','2021-12-01',1,51.5,0),
('IN-1015','CA-1015','2021-01-11','2021-12-01',0,52.3,0),
('IN-1016','CA-1000','2021-01-11','2021-12-01',1,51.4,0),
('IN-1017','CA-1001','2021-01-11','2021-12-01',0,48.2,0),
('IN-1018','CA-1002','2021-01-11','2021-12-01',0,50.3,0),
('IN-1019','CA-1003','2021-01-11','2021-12-01',1,51.2,0);
insert into treatements(id,deleted, doctor, kind_of_disease, medicine, note, quantily, treatement_date, individual_id) 
values('TR-1000', 0, 'Lê Quốc Tùng', 'Phòng LMHM', 'PRRS', 'Cho uống lại sau 3 tháng',1, '2021-01-11', 'IN-1000'),
('TR-1001', 0, 'Trần Nga My', 'Phòng H1N1', 'PMWS', 'Cho uống lại sau 6 tháng',3, '2021-01-11', 'IN-1001'),
('TR-1002', 0, 'Lê Quốc Tùng', 'Phòng LMHM', 'PRRS', 'Cho uống lại sau 3 tháng',1, '2021-01-12', 'IN-1002'),
('TR-1003', 0, 'Ngô Văn Tuấn', 'Chữa huyết trùng lợn', 'NOVMAE E1', 'Cho uống lại sau 1 năm',2, '2021-01-12', 'IN-1003'),
('TR-1004', 0, 'Lê Quốc Đạt', 'Phòng tả lợn', 'TL1103', 'Cho uống lại sau 6 tháng',4, '2021-01-13', 'IN-1004'),
('TR-1005', 0, 'Lê Quốc Đạt', 'Phòng tả lợn', 'TL1103', 'Cho uống lại sau 6 tháng',4, '2021-01-13', 'IN-1005'),
('TR-1006', 0, 'Ngô Bảo Châu', 'Phòng LMHM', 'PRRS', 'Cho uống lại sau 3 tháng',1, '2021-01-14', 'IN-1006'),
('TR-1007', 0, 'Trần Thái Sơn', 'Phòng LMHM', 'PRRS', 'Cho uống lại sau 3 tháng',1, '2021-01-14', 'IN-1007'),
('TR-1008', 0, 'Trần Thái Sơn', 'Phòng LMHM', 'PRRS', 'Cho uống lại sau 3 tháng',1, '2021-01-14', 'IN-1008'),
('TR-1009', 0, 'Trần Thái Sơn', 'Phòng LMHM', 'PRRS', 'Cho uống lại sau 3 tháng',1, '2021-01-14', 'IN-1009'),
('TR-1010', 0, 'Ngô Thừa Ân', 'Chữa huyết trùng lợn', 'NOVMAE E1', 'Cho uống lại sau 1 năm',2, '2021-01-15', 'IN-1001'),
('TR-1011', 0, 'Ngô Thừa Ân', 'Chữa huyết trùng lợn', 'NOVMAE E1', 'Cho uống lại sau 1 năm',2, '2021-01-15', 'IN-1002'),
('TR-1012', 0, 'Ngô Thừa Ân', 'Chữa huyết trùng lợn', 'NOVMAE E1', 'Cho uống lại sau 1 năm',2, '2021-01-15', 'IN-1004'),
('TR-1013', 0, 'Ngô Thừa Ân', 'Chữa huyết trùng lợn', 'NOVMAE E1', 'Cho uống lại sau 1 năm',2, '2021-01-15', 'IN-1005'),
('TR-1014', 0, 'Trần Nga My', 'Phòng H1N1', 'PMWS', 'Cho uống lại sau 6 tháng',3, '2021-01-16', 'IN-1003'),
('TR-1015', 0, 'Trần Nga My', 'Phòng H1N1', 'PMWS', 'Cho uống lại sau 6 tháng',3, '2021-01-16', 'IN-1004'),
('TR-1016', 0, 'Trần Nga My', 'Phòng H1N1', 'PMWS', 'Cho uống lại sau 6 tháng',3, '2021-01-16', 'IN-1005'),
('TR-1017', 0, 'Trần Nga My', 'Phòng H1N1', 'PMWS', 'Cho uống lại sau 6 tháng',3, '2021-01-16', 'IN-1006'),
('TR-1018', 0, 'Trương Văn Quyết', 'Phòng tai xanh', 'TX M2', 'Cho uống lại sau 8 tháng',5, '2021-01-17', 'IN-1001'),
('TR-1019', 0, 'Trương Văn Quyết', 'Phòng tai xanh', 'TX M2', 'Cho uống lại sau 8 tháng',5, '2021-01-17', 'IN-1002'),
('TR-1020', 0, 'Trương Văn Quyết', 'Phòng tai xanh', 'TX M2', 'Cho uống lại sau 8 tháng',5, '2021-01-17', 'IN-1003');
package com.project.livestockfarmbe;

import com.project.livestockfarmbe.controller.NewsController;
import com.project.livestockfarmbe.model.news.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsRestControllerNewsListTaiVD {
    @Autowired
    private NewsController newsController;

    @Test
    public void showAllNews_6() {
        ResponseEntity< Page< News > > responseEntity
                = this.newsController.showAllNews
                (0, "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(22, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("22",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Để chủ động tổ chức kiểm soát tốt, không để các loại dịch bệnh nguy hiểm xảy ra diện rộng, bảo đảm nguồn cung thực phẩm, bảo đảm an toàn thực phẩm trong thời gian trước, trong và sau Tết Nguyên đán Nhâm Dần 2022, Sở Nông nghiệp và Phát triển nông thôn đã có văn bản đề nghị các huyện, thị xã, thành phố tập trung các nguồn lực và khẩn trương triển khai quyết liệt, đồng bộ các biện pháp phòng, chống dịch bệnh.\n" +
                        "Theo thông tin cập nhật từ Hệ thống quản lý dịch bệnh động vật Việt Nam (VAHIS) - Cục Thú y, tình hình dịch bệnh gia súc, gia cầm đang diễn biến rất phức tạp, đặc biệt là các bệnh Dịch tả lợn Châu Phi, bệnh VDNC trâu bò, bệnh Cúm gia cầm; tại tỉnh ta mặc dù dịch bệnh trên đàn gia súc, gia cầm, động vật thủy sản cơ bản đã được kiểm soát hiệu quả. Tuy nhiên, nhận định nguy cơ các loại dịch bệnh nguy hiểm trên trên đàn vật nuôi vào đầu năm 2022 (vụ Đông Xuân) là rất cao, do một số nguyên nhân như sau: Tổng đàn vật nuôi, mật độ chăn nuôi tăng cao, trong đó chăn nuôi nhỏ lẻ vẫn chiếm tỷ trọng lớn, các biện pháp chăn nuôi an toàn sinh học, vệ sinh, sát trùng phòng bệnh còn hạn chế ở nhiều nơi. Các hoạt động buôn bán, vận chuyển, giết mổ động vật tăng mạnh để phục vụ nhu cầu trong thời gian trước, trong và sau Tết Nhâm Dần. Các loại mầm bệnh nguy hiểm tồn tại trong môi trường nhiều, khi gặp điều kiện thuận lợi sẽ xâm nhập gây bệnh, đặc biệt là vi rút gây bệnh DTLCP, VDNC trâu bò, nhất là các chủng Cúm gia cầm có tỷ lệ lưu hành rất cao (tỷ lệ lưu hành vi rút cúm A/H5N6, A/H5N8 trên địa bàn tỉnh năm 2021 là 5,25%). Đặc biệt thời tiết thay đổi chuyển mùa, làm giảm sức đề kháng của đàn vật nuôi và tạo thuận lợi cho mầm bệnh tồn tại, phát tán diện rộng và gây ra dịch bệnh.",
                responseEntity.getBody().getContent().get(1).getContent());
        Assertions.assertEquals("https://nguoichannuoi.vn/images/news/2022/02/11/original/nuoi-heo-dong-nai-2_1644538515.jpg",
                responseEntity.getBody().getContent().get(1).getImage());
        Assertions.assertEquals("2022-02-10 00:00:00.000000",
                responseEntity.getBody().getContent().get(1).getPostDate());
        Assertions.assertEquals("Trảng Bom (Đồng Nai): Tổng đàn gia súc, gia cầm tăng mạnh",
                responseEntity.getBody().getContent().get(1).getTitle());
        Assertions.assertEquals("NV-1002",
                responseEntity.getBody().getContent().get(1).getEmployee().getId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getTypeOfNews().getId());

    }

    @Test
    public void showNews_Title_Da_Nang_10() {

        ResponseEntity< Page< News > > responseEntity
                = this.newsController.showAllNews
                (0, "Da Nang", "");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    @Test
    public void showNews_Title_Thanh_Hoa_11() {

        ResponseEntity< Page< News > > responseEntity
                = this.newsController.showAllNews
                (0, "Thanh Hóa", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("11",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("Để chủ động tổ chức kiểm soát tốt, không để các loại dịch bệnh nguy hiểm xảy ra diện rộng, bảo đảm nguồn cung thực phẩm, bảo đảm an toàn thực phẩm trong thời gian trước, trong và sau Tết Nguyên đán Nhâm Dần 2022, Sở Nông nghiệp và Phát triển nông thôn đã có văn bản đề nghị các huyện, thị xã, thành phố tập trung các nguồn lực và khẩn trương triển khai quyết liệt, đồng bộ các biện pháp phòng, chống dịch bệnh.\n" +
                        "Theo thông tin cập nhật từ Hệ thống quản lý dịch bệnh động vật Việt Nam (VAHIS) - Cục Thú y, tình hình dịch bệnh gia súc, gia cầm đang diễn biến rất phức tạp, đặc biệt là các bệnh Dịch tả lợn Châu Phi, bệnh VDNC trâu bò, bệnh Cúm gia cầm; tại tỉnh ta mặc dù dịch bệnh trên đàn gia súc, gia cầm, động vật thủy sản cơ bản đã được kiểm soát hiệu quả. Tuy nhiên, nhận định nguy cơ các loại dịch bệnh nguy hiểm trên trên đàn vật nuôi vào đầu năm 2022 (vụ Đông Xuân) là rất cao, do một số nguyên nhân như sau: Tổng đàn vật nuôi, mật độ chăn nuôi tăng cao, trong đó chăn nuôi nhỏ lẻ vẫn chiếm tỷ trọng lớn, các biện pháp chăn nuôi an toàn sinh học, vệ sinh, sát trùng phòng bệnh còn hạn chế ở nhiều nơi. Các hoạt động buôn bán, vận chuyển, giết mổ động vật tăng mạnh để phục vụ nhu cầu trong thời gian trước, trong và sau Tết Nhâm Dần. Các loại mầm bệnh nguy hiểm tồn tại trong môi trường nhiều, khi gặp điều kiện thuận lợi sẽ xâm nhập gây bệnh, đặc biệt là vi rút gây bệnh DTLCP, VDNC trâu bò, nhất là các chủng Cúm gia cầm có tỷ lệ lưu hành rất cao (tỷ lệ lưu hành vi rút cúm A/H5N6, A/H5N8 trên địa bàn tỉnh năm 2021 là 5,25%). Đặc biệt thời tiết thay đổi chuyển mùa, làm giảm sức đề kháng của đàn vật nuôi và tạo thuận lợi cho mầm bệnh tồn tại, phát tán diện rộng và gây ra dịch bệnh.",
                responseEntity.getBody().getContent().get(0).getContent());
        Assertions.assertEquals("https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/tiem-cho-ga-th-1.jpg",
                responseEntity.getBody().getContent().get(0).getImage());
        Assertions.assertEquals("2022-02-10 00:00:00.000000",
                responseEntity.getBody().getContent().get(0).getPostDate());
        Assertions.assertEquals("Thanh Hóa: Triển khai các biện pháp phòng, chống dịch bệnh động vật trước, trong và sau Tết Nguyên đán Nhâm Dần 2022",
                responseEntity.getBody().getContent().get(0).getTitle());
        Assertions.assertEquals("NV-1002",
                responseEntity.getBody().getContent().get(0).getEmployee().getId());
        Assertions.assertEquals(3,
                responseEntity.getBody().getContent().get(0).getTypeOfNews().getId());

    }

    @Test
    public void showNews_TypeNews_NotFound_10() {
        ResponseEntity< Page< News > > responseEntity
                = this.newsController.showAllNews
                (0, "", "4");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    @Test
    public void showNews_Focus_11() {

        ResponseEntity< Page< News > > responseEntity
                = this.newsController.showAllNews
                (0, "", "1");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(8, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("21",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Từ điều kiện địa lý, Hà Nội có tiềm năng, lợi thế phát triển chăn nuôi bò thịt, bò sữa. Thời gian qua, nhiều địa phương trên địa bàn thành phố đã đưa giống bò mới vào sản xuất, đạt hiệu quả cao. Tuy nhiên, để chăn nuôi bò phát triển bền vững, các địa phương, đơn vị còn nhiều việc phải làm.\n" +
                        "Bà Trương Thị Kiểm ở xã Vân Hòa (huyện Ba Vì) cho biết, gia đình bà đang nuôi 6 con bò sữa, bán được sữa với giá bình quân 11.000 - 14.000 đồng/lít. Chăn nuôi bò sữa vất vả nhưng ổn định, không biến động như chăn nuôi lợn, gà... Còn hộ ông Đặng Đình Hậu ở xã Lam Điền (huyện Chương Mỹ) đang nuôi tổng đàn khoảng 100 con bò thịt giống BBB. Đây là giống bò cho năng suất, chất lượng cao, doanh thu đạt khoảng 700 triệu đồng/năm, trừ các khoản chi phí, lãi 350 triệu đồng/năm. “Nếu như trước đây, bò thịt truyền thống cho lãi 5 - 6 triệu đồng/năm thì các giống bò lai cho lãi 8 - 10 triệu đồng/con”, ông Hậu chia sẻ.",
                responseEntity.getBody().getContent().get(1).getContent());
        Assertions.assertEquals("https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/z300-Nguoi-chan-nuoi-196.jpg",
                responseEntity.getBody().getContent().get(1).getImage());
        Assertions.assertEquals("2022-02-09 00:00:00.000000",
                responseEntity.getBody().getContent().get(1).getPostDate());
        Assertions.assertEquals("7 giống gà quý hiếm tại Việt Nam",
                responseEntity.getBody().getContent().get(1).getTitle());
        Assertions.assertEquals("NV-1006",
                responseEntity.getBody().getContent().get(1).getEmployee().getId());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getTypeOfNews().getId());
    }

    @Test
    public void showNewsBy_Title_TypeNews_11() {

        ResponseEntity< Page< News > > responseEntity
                = this.newsController.showAllNews
                (0, "thú y", "3");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("19",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("(Người Chăn Nuôi) - Trước đây, nhiều sinh viên học chăn nuôi, thú y khi mới ra trường thường phải chọn làm \"trái tay\". Nay, họ được các công ty, phòng khám \"trải thảm\" mời về, trả lương cao, lại còn được đào tạo lại. \"Bác sĩ thú y\" đang là từ khóa được tìm nhiều nhất trong các ngành học liên quan nông nghiệp, trên các trang tìm kiếm hiện nay.\n" +
                        "Mấy tuần qua, chị TN cố gắng thông qua mọi kênh giới thiệu việc làm, bạn bè và những hội nhóm trên mạng xã hội để đăng tin tuyển dụng bác sĩ thú y. Mức lương cho vị trí này không thấp hơn 20 triệu đồng/tháng và vị trí này sẽ có việc làm ngay sau buổi phỏng vấn đạt yêu cầu. Chị TN cho biết, yêu cầu đặt ra cho vị trí bác sĩ thú y là phải giỏi tiếng Anh, vì sẽ phải bay sang Australia, New Zealand trực tiếp tuyển chọn những con bò giống đạt chất lượng trước khi nhập về Việt Nam.",
                responseEntity.getBody().getContent().get(0).getContent());
        Assertions.assertEquals("https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/z300-Nguoi-chan-nuoi-55-.jpg",
                responseEntity.getBody().getContent().get(0).getImage());
        Assertions.assertEquals("2022-02-06 00:00:00.000000",
                responseEntity.getBody().getContent().get(0).getPostDate());
        Assertions.assertEquals("Rầm rộ tìm lao động thú y, chăn nuôi trình độ cao",
                responseEntity.getBody().getContent().get(0).getTitle());
        Assertions.assertEquals("NV-1001",
                responseEntity.getBody().getContent().get(0).getEmployee().getId());
        Assertions.assertEquals(3,
                responseEntity.getBody().getContent().get(0).getTypeOfNews().getId());
    }
}

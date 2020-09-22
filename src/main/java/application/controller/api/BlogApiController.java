package application.controller.api;


import application.data.model.Blog;
import application.data.service.BlogService;
import application.data.service.ProductService;
import application.model.api.DataApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/blog")
public class BlogApiController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private ProductService productService;



    @GetMapping(value = "/fake")
    public DataApiResult fakeblog(){
        DataApiResult result = new DataApiResult();
        try {
            Blog blog = new Blog();
            blog.setId(2);

            blog.setContent("<div class=\"container\">\n" +
                    "    <div class=\"row\">\n" +
                    "        <div class=\"col-lg-8\">\n" +
                    "            <div class=\"row\">\n" +
                    "                <div class=\"col-lg-12 col-sm-6 col-md-8\">\n" +
                    "                    <div class=\"dst-content\">\n" +
                    "                        <h2 class=\"dst-ctitle\">Đánh giá chi tiết</h2>\n" +
                    "                        <article class=\"area_article area_articleFull\" style=\"\">\n" +
                    "                            <p><span\n" +
                    "                                    style=\"font-size: 14pt; color: #ff6600;\"><b>Đánh giá chi tiết về iPhone 11</b></span>\n" +
                    "                            </p>\n" +
                    "                            <p>Liên tục cải tiến, không ngừng thay đổi chính là thông điệp mà các nhà sản xuất\n" +
                    "                                smartphone\n" +
                    "                                hàng đầu như Apple hướng đến. Trong quá trình phát triển của mình, nhiều điện thoại <a\n" +
                    "                                        href=\"https://didongthongminh.vn/iphone\">iPhone</a> đã ra đời và mới đây nhất là\n" +
                    "                                chiếc <strong><span style=\"color: #ff6600;\"><a style=\"color: #ff6600;\"\n" +
                    "                                                                               href=\"https://didongthongminh.vn/iphone-11-64gb-2019\">iPhone 11</a></span></strong>.\n" +
                    "                                Bài đánh giá chi tiết về iPhone 11 dưới đây sẽ giúp cho các bạn hiểu chi tiết hơn về sản\n" +
                    "                                phẩm này.</p>\n" +
                    "                            <div id=\"attachment_157821\" style=\"width: 710px\" class=\"wp-caption aligncenter\"><img\n" +
                    "                                    aria-describedby=\"caption-attachment-157821\" class=\"wp-image-157821\"\n" +
                    "                                    title=\"Apple iPhone 11\"\n" +
                    "                                    src=\"./iPhone 11 64Gb Đã Kích Hoạt CH_A mới trần kèm sạc cable chính hãng_files/iPhone-11-Purple.jpg\"\n" +
                    "                                    alt=\"Apple iPhone 11\" width=\"700\" height=\"394\"\n" +
                    "                                    srcset=\"https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-Purple.jpg 768w, https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-Purple-300x169.jpg 300w, https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-Purple-600x338.jpg 600w\"\n" +
                    "                                    sizes=\"(max-width: 700px) 100vw, 700px\">\n" +
                    "                                <p id=\"caption-attachment-157821\" class=\"wp-caption-text\">Apple iPhone 11</p></div>\n" +
                    "                            <p><span style=\"color: #ff6600;\"><b>Màn hình iPhone 11</b></span></p>\n" +
                    "                            <p><span style=\"font-weight: 400;\">iPhone 11 sử dụng công nghệ màn hình IPS, kích thước màn hình rộng 6.1 inch, thiết kế màn hình tai thỏ cùng độ phân giải 828 x 1792 pixels. Với đỉnh cao kết cấu của màn hình tinh thể lỏng, công nghệ IPS góp phần nâng cao giá trị hiệu năng cho iPhone 11. Đồng thời, kích thước màn hình vượt xa so với tiêu chuẩn phổ thông (khoảng 4-5 inch) đem đến trải nghiệm tốt hơn cho người dùng.&nbsp;</span>\n" +
                    "                            </p>\n" +
                    "                            <p>&nbsp;</p>\n" +
                    "                            <p><span style=\"color: #ff6600;\"><b>Hiệu năng iPhone 11</b></span></p>\n" +
                    "                            <p><span style=\"font-weight: 400;\">Tương tự như các dòng sản phẩm của Apple, iPhone 11 sử dụng hệ điều hành và con chip CPU độc quyền của hãng. Chip A13 đời mới của Apple nâng cấp cao hơn hẳn so với các đời chip trước đó, cộng hưởng với thiết kế trên tiến trình 7nm+ cùng yếu tố đa nhân (sáu nhân) cho hiệu năng cao hơn và khả năng đa nhiệm tốt hơn nhiều lần so với các sản phẩm trước. Cùng với đó, việc tích hợp chip A13 trên hệ điều hành iOS 13 mang đến cho iPhone 11 tốc độ xử lý thông tin đáng kinh ngạc, đảm bảo quá trình trải nghiệm ứng dụng tuyệt vời cho người sử dụng.&nbsp;</span>\n" +
                    "                            </p>\n" +
                    "                            <div id=\"attachment_157822\" style=\"width: 670px\" class=\"wp-caption aligncenter\"><img\n" +
                    "                                    aria-describedby=\"caption-attachment-157822\" class=\"wp-image-157822 size-full\"\n" +
                    "                                    title=\"iPhone 11 có hiệu năng rất mạnh mẽ\"\n" +
                    "                                    src=\"./iPhone 11 64Gb Đã Kích Hoạt CH_A mới trần kèm sạc cable chính hãng_files/iPhone-11-1.jpg\"\n" +
                    "                                    alt=\"iPhone 11 có hiệu năng rất mạnh mẽ\" width=\"660\" height=\"371\"\n" +
                    "                                    srcset=\"https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-1.jpg 660w, https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-1-300x169.jpg 300w, https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-1-600x337.jpg 600w\"\n" +
                    "                                    sizes=\"(max-width: 660px) 100vw, 660px\">\n" +
                    "                                <p id=\"caption-attachment-157822\" class=\"wp-caption-text\">iPhone 11 có hiệu năng rất\n" +
                    "                                    mạnh\n" +
                    "                                    mẽ</p></div>\n" +
                    "                            <p><span style=\"font-weight: 400;\"><a href=\"https://didongthongminh.vn/iphone-11-64gb-2019\">iPhone 11</a> sử dụng Apple GPU (bốn nhân), đây là bộ xử lý đồ họa được hãng tự thiết kế riêng, cho khả năng tương thích tối ưu khi đồng bộ trên thiết bị nội bộ. Yếu tố đa nhân giúp cho GPU của iPhone 11 có khả năng tiếp nhận và xử lý thông tin đồ họa một cách nhanh chóng, tạo ra hình ảnh hiển thị liên tục trên màn hình để trải nghiệm luôn mượt mà ngay cả khi sử dụng tác vụ nặng, nhất là chơi game.&nbsp;&nbsp;</span>\n" +
                    "                            </p>\n" +
                    "                            <p>&nbsp;</p>\n" +
                    "                            <p><span style=\"color: #ff6600;\"><b>Camera iPhone 11</b></span></p>\n" +
                    "                            <p><span style=\"font-weight: 400;\">iPhone 11 được trang bị bộ camera kép tại mặt lưng với đôh phân giải 12 MP, f/1.8 và 12 MP, f/2.4. Song song với đó là thiết kế camera đơn tại mặt trước với độ phân giải đạt mức 12 MP, f/2.2. Bộ ba camera này tạo dựng hiệu ứng hình ảnh tốt, m</span>ở\n" +
                    "                                rộng góc chụp do được bổ sung thêm một camera góc rộng tại mặt sau. Từ đó, chất lượng\n" +
                    "                                ảnh\n" +
                    "                                chụp nâng cao hơn, hình ảnh sắc nét, màu sắc chân thật, kích thước bức hình tăng, số\n" +
                    "                                lượng\n" +
                    "                                các vật thể trong bức ảnh cũng cải thiện đáng kể cùng hiệu ứng chụp ảnh xóa phông với\n" +
                    "                                cảm\n" +
                    "                                biến chiều sâu ấn tượng.</p>\n" +
                    "                            <div id=\"attachment_157823\" style=\"width: 710px\" class=\"wp-caption aligncenter\"><img\n" +
                    "                                    aria-describedby=\"caption-attachment-157823\" class=\"wp-image-157823\"\n" +
                    "                                    title=\"Camera trên iPhone 11\"\n" +
                    "                                    src=\"./iPhone 11 64Gb Đã Kích Hoạt CH_A mới trần kèm sạc cable chính hãng_files/iPhone-11-Camera-Module.jpg\"\n" +
                    "                                    alt=\"Camera trên iPhone 11\" width=\"700\" height=\"350\"\n" +
                    "                                    srcset=\"https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-Camera-Module.jpg 768w, https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-Camera-Module-300x150.jpg 300w, https://cdn.didongthongminh.vn/upload_images/2019/09/iPhone-11-Camera-Module-600x300.jpg 600w\"\n" +
                    "                                    sizes=\"(max-width: 700px) 100vw, 700px\">\n" +
                    "                                <p id=\"caption-attachment-157823\" class=\"wp-caption-text\">Camera trên iPhone 11</p>\n" +
                    "                            </div>\n" +
                    "                            <p>Đặc biệt, cả camera trước và sau của iPhone 11 đều được thiết kế để quay video chậm với\n" +
                    "                                tốc\n" +
                    "                                độ khung hình tối đa của camera selfie là 120fps, camera sau là 240fps.</p>\n" +
                    "                            <p>&nbsp;</p>\n" +
                    "                            <p><span style=\"color: #ff6600;\"><b>Pin iPhone 11</b></span></p>\n" +
                    "                            <p><span style=\"font-weight: 400;\">Pin của <a\n" +
                    "                                    href=\"https://didongthongminh.vn/iphone-11-64gb-2019\">iPhone 11</a> được trang bị là dòng pin Li-ion, mức dung lượng 3110 mAh. Đây là dòng pin hiện hành cho các sản phẩm smartphone nổi bật nhờ có mật độ năng lượng cao, ít bị tình trạng tự xả. Đặc biệt dung lượng pin lớn kéo dài thời gian trải nghiệm ứng dụng cho người dùng.&nbsp;</span>\n" +
                    "                            </p>\n" +
                    "                            <p><span style=\"font-weight: 400;\">Bên cạnh đó, chiếc iPhone 11 được Apple hỗ trợ sạc nhanh trên bộ sạc 18W, tốc độ sạc đầy 50% pin ước tính chỉ trong thời gian 30 phút.</span>\n" +
                    "                            </p>\n" +
                    "                            <p><img class=\"aligncenter wp-image-157825\"\n" +
                    "                                    src=\"./iPhone 11 64Gb Đã Kích Hoạt CH_A mới trần kèm sạc cable chính hãng_files/iphone11-review.jpg\"\n" +
                    "                                    alt=\"\" width=\"700\" height=\"366\"\n" +
                    "                                    srcset=\"https://cdn.didongthongminh.vn/upload_images/2019/09/iphone11-review.jpg 768w, https://cdn.didongthongminh.vn/upload_images/2019/09/iphone11-review-300x157.jpg 300w, https://cdn.didongthongminh.vn/upload_images/2019/09/iphone11-review-600x314.jpg 600w\"\n" +
                    "                                    sizes=\"(max-width: 700px) 100vw, 700px\"></p>\n" +
                    "                            <p><span style=\"color: #ff6600;\"><b>Chế độ bảo mật</b></span></p>\n" +
                    "                            <p><span style=\"font-weight: 400;\">Bảo mật smartp</span>hone là một trong những tính năng\n" +
                    "                                hàng\n" +
                    "                                đầu được người dùng quan tâm. Bởi lẽ, thời gian gần đây, tình trạng đánh cắp thông tin,\n" +
                    "                                dữ\n" +
                    "                                liệu trên điện thoại cá nhân xảy ra khá phổ biến. Do đó, để phù hợp với nhu cầu thị\n" +
                    "                                trường,\n" +
                    "                                nhà sản xuất Apple đã nâng cấp bảo mật cho iPhone 11 bằng hình thức Face ID thay vì nhận\n" +
                    "                                diện vân tay hay bảo mật số như nhiều sản phẩm khác.</p>\n" +
                    "                            <p>Nhận diện gương mặt được đánh giá là cơ chế bảo mật có độ an toàn rất cao. Theo nghiên\n" +
                    "                                cứu,\n" +
                    "                                hình dáng khuôn mặt của một người sẽ được định hình từ rất sớm và gần như không biến\n" +
                    "                                đổi.\n" +
                    "                                Bên cạnh đó, các yếu tố trên gương mặt mỗi người mang tính chất đặc trưng riêng biệt,\n" +
                    "                                ngay\n" +
                    "                                cả các cặp đa sinh cũng không giống nhau hoàn toàn về khuôn mặt.</p>\n" +
                    "                            <div id=\"attachment_157429\" style=\"width: 710px\" class=\"wp-caption aligncenter\"><img\n" +
                    "                                    aria-describedby=\"caption-attachment-157429\" class=\"wp-image-157429\"\n" +
                    "                                    title=\"iPhone 11 có 6 phiên bản màu\"\n" +
                    "                                    src=\"./iPhone 11 64Gb Đã Kích Hoạt CH_A mới trần kèm sạc cable chính hãng_files/iPhone-XR-vs-iPhone-11R-3.jpg\"\n" +
                    "                                    alt=\"iPhone 11 có 6 phiên bản màu\" width=\"700\" height=\"375\"\n" +
                    "                                    srcset=\"https://cdn.didongthongminh.vn/upload_images/2019/10/iPhone-XR-vs-iPhone-11R-3.jpg 768w, https://cdn.didongthongminh.vn/upload_images/2019/10/iPhone-XR-vs-iPhone-11R-3-300x161.jpg 300w, https://cdn.didongthongminh.vn/upload_images/2019/10/iPhone-XR-vs-iPhone-11R-3-600x321.jpg 600w\"\n" +
                    "                                    sizes=\"(max-width: 700px) 100vw, 700px\">\n" +
                    "                                <p id=\"caption-attachment-157429\" class=\"wp-caption-text\">iPhone 11 có 6 phiên bản\n" +
                    "                                    màu</p>\n" +
                    "                            </div>\n" +
                    "                            <p><span style=\"font-weight: 400;\">Không chỉ ấn tượng bởi các thông số kỹ thuật về cấu hình, iPhone 11 còn được Apple tung ra thị trường với nhiều tùy chọn màu sắc (sáu màu bao gồm: đen, xanh, vàng, tím, đỏ, trắng) và các phiên bản bộ nhớ khác nhau (64GB, 128GB, 256GB). Sự đa dạng này tăng thêm lựa chọn cho người tiêu dùng trong quá trình tìm mua sản phẩm./.</span>\n" +
                    "                            </p>\n" +
                    "                        </article>\n" +
                    "                        <p class=\"show-more\" style=\"display: none;\" onclick=\"showArticle();\">\n" +
                    "                            <a href=\"javascript:;\" class=\"readmore\">Đọc thêm </a>\n" +
                    "                        </p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"col-lg-4\">\n" +
                    "            <div class=\"row\">\n" +
                    "                <div class=\"col-lg-12 col-sm-6 col-md-4\">\n" +
                    "                    <div class=\"dst-attr\" id=\"patt\">\n" +
                    "                        <h2 class=\"dst-ctitle\">Thông số kỹ thuật</h2>\n" +
                    "                        <div style=\"display:none;margin:15px auto;text-align:center;font-size:16px;\">iPhone 11 64Gb Đã\n" +
                    "                            Kích\n" +
                    "                            Hoạt CH/A\n" +
                    "                        </div>\n" +
                    "                        <table class=\"shop_attributes\">\n" +
                    "\n" +
                    "\n" +
                    "                            <tbody>\n" +
                    "                            <tr>\n" +
                    "                                <th>Băng tần - Sim</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/bang-tan-sim/2g-3g-4g-lte\" rel=\"tag\">2G, 3G,\n" +
                    "                                    4G\n" +
                    "                                    LTE</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Màn hình</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/man-hinh/ips-lcd-6-1-inches\" rel=\"tag\">IPS\n" +
                    "                                    LCD ,\n" +
                    "                                    6.1 inches</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>CPU</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/cpu/apple-a13-bionic\" rel=\"tag\">Apple A13\n" +
                    "                                    Bionic</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>RAM</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/ram/4-gb\" rel=\"tag\">4 GB</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Bộ nhớ trong</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/bo-nho-trong/64-gb\" rel=\"tag\">64 GB</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Camera sau</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/camera-sau/dual-12-mp\" rel=\"tag\">Dual 12\n" +
                    "                                    MP</a>\n" +
                    "                                </p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Camera trước</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/camera-truoc/12mp\" rel=\"tag\">12MP</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Sim</th>\n" +
                    "                                <td><p><a\n" +
                    "                                        href=\"https://didongthongminh.vn/sim/single-sim-nano-sim-or-dual-sim-nano-sim-dual-stand-by\"\n" +
                    "                                        rel=\"tag\">Single SIM (Nano-SIM) or Dual SIM (Nano-SIM, dual stand-by)</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Cảm biến</th>\n" +
                    "                                <td><p><a\n" +
                    "                                        href=\"https://didongthongminh.vn/cam-bien/face-id-accelerometer-gyro-proximity-compass-barometer\"\n" +
                    "                                        rel=\"tag\">Face ID, accelerometer, gyro, proximity, compass, barometer</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Bảo mật nâng cao</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/bao-mat-nang-cao/faceid\" rel=\"tag\">FaceID</a>\n" +
                    "                                </p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Pin</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/pin/li-ion-3110-mah\" rel=\"tag\">Li-Ion 3110\n" +
                    "                                    mAh</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Màu sắc</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/mau-sac/den\" rel=\"tag\">Đen</a>, <a\n" +
                    "                                        href=\"https://didongthongminh.vn/mau-sac/do\" rel=\"tag\">Đỏ</a>, <a\n" +
                    "                                        href=\"https://didongthongminh.vn/mau-sac/tim\" rel=\"tag\">Tím</a>, <a\n" +
                    "                                        href=\"https://didongthongminh.vn/mau-sac/trang\" rel=\"tag\">Trắng</a>, <a\n" +
                    "                                        href=\"https://didongthongminh.vn/mau-sac/vang\" rel=\"tag\">Vàng</a>, <a\n" +
                    "                                        href=\"https://didongthongminh.vn/mau-sac/xanh-la\" rel=\"tag\">Xanh lá</a></p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <th>Tình trạng sản phẩm</th>\n" +
                    "                                <td><p><a href=\"https://didongthongminh.vn/tinh-trang-san-pham/moi\" rel=\"tag\">New</a>\n" +
                    "                                </p>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            </tbody>\n" +
                    "                        </table>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>");
            blogService.addNewBlog(blog);
            result.setData(blog.getId());
            result.setMessage("Save category successfully: " + blog.getId());
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}


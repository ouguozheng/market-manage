package cn.lmjia.market.core.service.request;

import cn.lmjia.market.core.entity.Login;
import cn.lmjia.market.core.entity.request.PromotionRequest;
import me.jiangcai.user.notice.UserNoticeType;
import me.jiangcai.user.notice.wechat.WechatSendSupplier;
import org.springframework.transaction.annotation.Transactional;

/**
 * 升级申请服务
 * 支付通知：OPENTM409997458
 * 通过通知：OPENTM205211943
 *
 * @author CJ
 */
public interface PromotionRequestService {

    /**
     * @param login
     * @return 当前申请；或者null
     */
    @Transactional(readOnly = true)
    PromotionRequest currentRequest(Login login);

    PromotionRequest initRequest(Login login, int type, String address, String cardBackPath, String cardFrontPath, String businessLicensePath);

    void submitRequest(PromotionRequest request);

    UserNoticeType getPaySuccessMessage();

    void registerNotices(WechatSendSupplier wechatSendSupplier);
}

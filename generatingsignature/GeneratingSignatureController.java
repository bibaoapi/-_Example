package com.ergu.vctlh.generatingsignature;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/****************************************************************************************************
 * @author PLJ
 * @create 2018/8/17 0017 9:07
 * @descriptions <p>生成签名Demo</p >
 * @params 
 * @return 
 ****************************************************************************************************/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "GeneratingSignatureController")
public class GeneratingSignatureController {

	
	 
	/****************************************************************************************************
	 * @author PLJ
	 * @create 2018/8/17 0017 9:06
	 * @descriptions <p>
     *      String privateKey 私钥
     *      request中参数 调用借口的时，除sign以外的所有参数
     *      【例如：调用（委托订单列表）/vct-lh/api/coin/coinorder?coin_name=soc&quote_name=usdt&order_status=3&order_type=1&page_size=1&page_num=2&token=XXXXXXXXX&sign=XXXXXXXX
     *      coin_name:soc
     *      quote_name:usdt
     *      order_status:3
     *      order_type:3
     *      page_size:1
     *      page_num:2
     *      token:84001642a03111e882a1e0d55e6d69f3】
     *     </p >
	 * @params
	 * @return
	 ****************************************************************************************************/
	@RequestMapping(value = "/generatingSignature")
    public String generatingSignature(HttpServletRequest request, String privateKey) throws Exception {
        String sign = new RSAUtil().generatingSignature(request.getParameterMap(),privateKey);
        return sign;
    }

	
}

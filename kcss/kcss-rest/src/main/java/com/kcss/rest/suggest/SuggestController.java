package com.kcss.rest.suggest;

import com.kcss.biz.common.Platform;
import com.kcss.biz.common.XResponse;
import com.kcss.biz.record.auth.AuthConstants;
import com.kcss.biz.record.auth.token.CheckToken;
import com.kcss.biz.suggest.SuggestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * SuggestController class.
 *
 * @author X
 * @date: 2018/11/28
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@RestController
@RequestMapping("/api/suggest")
@Api(description = "反馈意见")
public class SuggestController {

    @Autowired
    private SuggestService suggestService;

    @CheckToken
    @PostMapping("/advise")
    public XResponse advise(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform,
            @ApiParam(name = "content", value = "意见文本内容", required = true)
            @RequestParam(value = "content")
                    String content
    ){

        return suggestService.advise(token,platform,content);
    }


}

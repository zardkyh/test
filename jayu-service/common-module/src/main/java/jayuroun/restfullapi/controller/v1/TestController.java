package jayuroun.restfullapi.controller.v1;

import jayuroun.restfullapi.model.req.TestRequest;
import jayuroun.restfullapi.service.TestService;
import jayuroun.core.model.response.SingleResult;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jayuroun.core.model.response.CommonResult;
import jayuroun.core.service.ResponseService;

import javax.validation.Valid;

/**
 * -------------------------------------------------------------------------------------
 * ::::::'OO::::'OOO::::'OO:::'OO:'OO::::'OO:'OOOOOOOO:::'OOOOOOO::'OO::::'OO:'OO....OO:
 * :::::: OO:::'OO OO:::. OO:'OO:: OO::::.OO: OO.....OO:'OO.....OO: OO:::: OO: OOO...OO:
 * :::::: OO::'OO:..OO:::. OOOO::: OO::::.OO: OO::::.OO: OO::::.OO: OO:::: OO: OOOO..OO:
 * :::::: OO:'OO:::..OO:::. OO:::: OO::::.OO: OOOOOOOO:: OO::::.OO: OO:::: OO: OO.OO.OO:
 * OO:::: OO: OOOOOOOOO:::: OO:::: OO::::.OO: OO.. OO::: OO::::.OO: OO:::: OO: OO..OOOO:
 * :OO::::OO: OO.....OO:::: OO:::: OO::::.OO: OO::. OO:: OO::::.OO: OO:::: OO: OO:..OOO:
 * ::OOOOOO:: OO:::..OO:::: OO::::. OOOOOOO:: OO:::. OO:. OOOOOOO::. OOOOOOO:: OO::..OO:
 * :......:::..:::::..:::::..::::::.......:::..:::::..:::.......::::.......:::..::::..::
 * <p>
 * TestController 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.common.controller.v1.TestController
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/common/test")
public class TestController {

    private final ResponseService responseService;

    private final TestService testService;






    @GetMapping(value = "/{id}")
    public SingleResult<TestRequest> testDetail(@PathVariable("id") long id) {

        return responseService.getSingleResult( testService.detail(id) );
    }

    @PostMapping(value = "/{id}")
    public SingleResult<TestRequest> postTest(@PathVariable("id") long id, @RequestBody @Valid TestRequest testRequest) {

        return responseService.getSingleResult( testService.detail(id) );
    }

    @PutMapping(value = "/{id}")
    public SingleResult<TestRequest> putTest(@PathVariable("id") long id, @RequestBody @Valid TestRequest testRequest) {

        return responseService.getSingleResult( testService.detail(id) );
    }

    @DeleteMapping(value = "/{id}")
    public CommonResult deleteTest(@PathVariable("id") long id) {
        return responseService.getSuccessResult();
    }




}

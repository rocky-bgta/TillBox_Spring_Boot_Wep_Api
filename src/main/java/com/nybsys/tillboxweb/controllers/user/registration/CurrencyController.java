/**
 * Created By: Md. Abdul Hannan
 * Created Date: 2/9/2018
 * Time: 10:37 AM
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */
package com.nybsys.tillboxweb.controllers.user.registration;

import com.nybsys.tillboxweb.constant.UserRegConst;
import com.nybsys.tillboxweb.core.Core;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.expense.BlankModel;
import com.nybsys.tillboxweb.models.user.registration.CurrencyModel;
import com.nybsys.tillboxweb.models.user.registration.VMCurrencyExchangeRateRequestModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_USER_REGISTRATION_MODULE_TOPIC;


@RestController
@RequestMapping(UserRegConst.CURRENCY_BASE_URL)
@Api(tags = "User-Registration",value = UserRegConst.CURRENCY_CONTROLLER_NAME, description = UserRegConst.CURRENCY_CONTROLLER_DESCRIPTION)
public class CurrencyController extends Core {

    @ApiOperation(value = UserRegConst.CURRENCY_SAVE_DESCRIPTION, response = CurrencyModel.class)
    @RequestMapping(value = UserRegConst.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_BASE_URL + UserRegConst.SAVE , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.BASE_CURRENCY_GET_DESCRIPTION, response = CurrencyModel.class)
    @RequestMapping(value = UserRegConst.BASE_CURRENCY_GET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getBaseCurrency(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_BASE_URL + UserRegConst.BASE_CURRENCY_GET , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = UserRegConst.CURRENCY_SEARCH_DESCRIPTION, response = CurrencyModel.class)
    @RequestMapping(value = UserRegConst.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_BASE_URL + UserRegConst.SEARCH , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.CURRENCY_SELECT_DESCRIPTION, response = CurrencyModel.class)
    @RequestMapping(value = UserRegConst.SELECT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage selectCurrentCurrency(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_BASE_URL + UserRegConst.SELECT, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = UserRegConst.CURRENCY_GET_CURRENCY_EXCHANGE_RATE_DESCRIPTION, response = VMCurrencyExchangeRateRequestModel.class)
    @RequestMapping(value = UserRegConst.CURRENCY_GET_CURRENCY_EXCHANGE_RATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllTodaysCurrencyExchangeRateByBusinessID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_BASE_URL + UserRegConst.CURRENCY_GET_CURRENCY_EXCHANGE_RATE , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = UserRegConst.CURRENCY_GET_ALL_CURRENCY_EXCHANGE_RATE_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = UserRegConst.CURRENCY_GET_ALL_CURRENCY_EXCHANGE_RATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllCurrencyExchangeRateByBusinessID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_BASE_URL + UserRegConst.CURRENCY_GET_ALL_CURRENCY_EXCHANGE_RATE , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }
}

/**
 * Created By: Md. Rashed Khan Menon
 * Created Date: 22/02/2018
 * Time: 04:44
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */

package com.nybsys.tillboxweb.controllers.common;

import com.nybsys.tillboxweb.constant.CommonModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.common.AddressTypeModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_COMMON_MODULE_TOPIC;

@RestController
@RequestMapping(CommonModuleConstant.ADDRESS_TYPE_BASE_URL)
@Api(tags = "Common",value  = CommonModuleConstant.ADDRESS_TYPE_CONTROLLER_NAME,description = CommonModuleConstant.ADDRESS_TYPE_CONTROLLER_DESCRIPTION)
public class AddressTypeController {

    @ApiOperation(value = CommonModuleConstant.ADDRESS_TYPE_SAVE_DESCRIPTION, response = AddressTypeModel.class)
    @RequestMapping(value = CommonModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(CommonModuleConstant.ADDRESS_TYPE_BASE_URL+CommonModuleConstant.SAVE, WORKER_COMMON_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = CommonModuleConstant.ADDRESS_TYPE_SEARCH_DESCRIPTION, response = AddressTypeModel.class)
    @RequestMapping(value = CommonModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(CommonModuleConstant.ADDRESS_TYPE_BASE_URL+CommonModuleConstant.SEARCH, WORKER_COMMON_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }


    @ApiOperation(value = CommonModuleConstant.ADDRESS_TYPE_GET_BY_ID_DESCRIPTION, response = AddressTypeModel.class)
    @RequestMapping(value = CommonModuleConstant.GET_BY_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage delete(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(CommonModuleConstant.ADDRESS_TYPE_BASE_URL+CommonModuleConstant.GET_BY_ID, WORKER_COMMON_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
}

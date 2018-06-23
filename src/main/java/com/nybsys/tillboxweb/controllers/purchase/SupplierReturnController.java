/**
 * Created By: Md. Abdul Hannan
 * Created Date: 2/26/2018
 * Time: 12:05 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */
package com.nybsys.tillboxweb.controllers.purchase;

import com.nybsys.tillboxweb.constant.PurchaseModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.purchase.SupplierInvoiceModel;
import com.nybsys.tillboxweb.models.purchase.SupplierReturnModel;
import com.nybsys.tillboxweb.models.purchase.VMSupplierReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_PURCHASE_MODULE_TOPIC;

@RestController
@RequestMapping(PurchaseModuleConstant.SUPPLIER_RETURN_BASE_URL)
@Api(tags = "Purchase")
public class SupplierReturnController {

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_RETURN_SAVE_DESCRIPTION, response = VMSupplierReturn.class)
    @RequestMapping(value = PurchaseModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_RETURN_BASE_URL+PurchaseModuleConstant.SAVE
                ,WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_RETURN_SEARCH_DESCRIPTION, response = SupplierReturnModel.class)
    @RequestMapping(value = PurchaseModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_RETURN_BASE_URL+PurchaseModuleConstant.SEARCH
                ,WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_RETURN_GET_BY_ID_DESCRIPTION, response = SupplierReturnModel.class)
    @RequestMapping(value = PurchaseModuleConstant.GET_BY_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_RETURN_BASE_URL+PurchaseModuleConstant.GET_BY_ID
                ,WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }



    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_RETURN_DELETE_DESCRIPTION, response = SupplierReturnModel.class)
    @RequestMapping(value = PurchaseModuleConstant.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage delete(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_RETURN_BASE_URL+PurchaseModuleConstant.DELETE
                ,WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "get supplier return list", response = SupplierReturnModel.class)
    @RequestMapping(value = "getSupplierReturnList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getSupplierReturnList(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_RETURN_BASE_URL + "getSupplierReturnList"
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

}

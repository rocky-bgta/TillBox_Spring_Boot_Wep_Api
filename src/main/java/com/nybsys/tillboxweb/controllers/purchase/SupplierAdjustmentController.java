/**
 * Created By: Md. Rashed Khan Menon
 * Created Date: 05/03/2018
 * Time: 10:21
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */

package com.nybsys.tillboxweb.controllers.purchase;

import com.nybsys.tillboxweb.constant.PurchaseModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.accounting.OpeningBalanceModel;
import com.nybsys.tillboxweb.models.common.VMItemAdjustmentModel;
import com.nybsys.tillboxweb.models.purchase.SupplierAdjustmentModel;
import com.nybsys.tillboxweb.models.purchase.SupplierInvoiceModel;
import com.nybsys.tillboxweb.models.purchase.VMSupplierAdjustmentModel;
import com.nybsys.tillboxweb.models.purchase.VMUnPaidInvoicesModel;
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
@RequestMapping(PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_BASE_URL)
@Api(tags = "Purchase")
public class SupplierAdjustmentController {

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_SAVE_DESCRIPTION, response = VMSupplierAdjustmentModel.class)
    @RequestMapping(value = PurchaseModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_BASE_URL + PurchaseModuleConstant.SAVE
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_SEARCH_DESCRIPTION, response = SupplierAdjustmentModel.class)
    @RequestMapping(value = PurchaseModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_BASE_URL + PurchaseModuleConstant.SEARCH
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_GET_BY_ID_DESCRIPTION, response = SupplierAdjustmentModel.class)
    @RequestMapping(value = PurchaseModuleConstant.GET_BY_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_BASE_URL + PurchaseModuleConstant.GET_BY_ID
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_DELETE_DESCRIPTION, response = SupplierAdjustmentModel.class)
    @RequestMapping(value = PurchaseModuleConstant.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage delete(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_BASE_URL + PurchaseModuleConstant.DELETE
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_ADJUST_OPENING_BALANCE_DESCRIPTION, response = OpeningBalanceModel.class)
    @RequestMapping(value = PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_ADJUST_OPENING_BALANCE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage adjustOpeningBalance(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_BASE_URL + PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_ADJUST_OPENING_BALANCE
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = PurchaseModuleConstant.SUPPLIER_DUE_BY_INVOICE_ID_DESCRIPTION, response = SupplierInvoiceModel.class)
    @RequestMapping(value = PurchaseModuleConstant.SUPPLIER_DUE_BY_INVOICE_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getSupplierDueByInvoiceID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(PurchaseModuleConstant.SUPPLIER_ADJUSTMENT_BASE_URL + PurchaseModuleConstant.SUPPLIER_DUE_BY_INVOICE_ID
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = VMItemAdjustmentModel.class)
    @RequestMapping(value = "getItemAdjustmentByProductID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getItemAdjustmentByProductID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/purchase/supplierAdjustment/getItemAdjustmentByProductID"
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = VMUnPaidInvoicesModel.class)
    @RequestMapping(value = "saveSupplierAdjustmentAmount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage saveSupplierAdjustmentAmount(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/purchase/supplierPayment/saveSupplierAdjustmentAmount"
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = Object.class)
    @RequestMapping(value = "getSupplierAdjustmentList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getSupplierAdjustmentList(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/purchase/supplierPayment/getSupplierAdjustmentList"
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = SupplierAdjustmentModel.class)
    @RequestMapping(value = "getSupplierAdjustmentByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getSupplierAdjustmentByID(@RequestBody RequestMessage requestMessage){

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/purchase/supplierAdjustment/getSupplierAdjustmentByID"
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = SupplierAdjustmentModel.class)
    @RequestMapping(value = "isSupplierAdjustmentEditable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage isSupplierAdjustmentEditable(@RequestBody RequestMessage requestMessage){

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/purchase/supplierAdjustment/isSupplierAdjustmentEditable"
                , WORKER_PURCHASE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
}

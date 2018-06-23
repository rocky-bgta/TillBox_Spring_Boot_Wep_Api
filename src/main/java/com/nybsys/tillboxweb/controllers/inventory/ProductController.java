/**
 * Created By: Md. Abdul Hannan
 * Created Date: 2/14/2018
 * Time: 12:46 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */
package com.nybsys.tillboxweb.controllers.inventory;
import com.nybsys.tillboxweb.constant.InventoryModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.accounting.AccountModel;
import com.nybsys.tillboxweb.models.expense.BlankModel;
import com.nybsys.tillboxweb.models.inventory.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_INVENTORY_MODULE_TOPIC;

@RestController
@RequestMapping(InventoryModuleConstant.PRODUCT_BASE_URL)
@Api(tags = "Inventory")
public class ProductController {

    @ApiOperation(value = InventoryModuleConstant.PRODUCT_SAVE_DESCRIPTION, response = VMProduct.class)
    @RequestMapping(value = InventoryModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.SAVE
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.PRODUCT_TYPE_DELETE_DESCRIPTION, response = AccountModel.class)
    @RequestMapping(value = InventoryModuleConstant.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage delete(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.DELETE
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.PRODUCT_SEARCH_DESCRIPTION, response = ProductModel.class)
    @RequestMapping(value = InventoryModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.SEARCH
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = InventoryModuleConstant.PRODUCT_LIKE_SEARCH_DESCRIPTION, response = ProductModel.class)
    @RequestMapping(value = InventoryModuleConstant.PRODUCT_LIKE_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage likeSearch(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.PRODUCT_LIKE_SEARCH
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.PRODUCT_SEARCH_WITH_STOCK_AND_PRICEK_DESCRIPTION, response = ProductModel.class)
    @RequestMapping(value = InventoryModuleConstant.PRODUCT_SEARCH_WITH_STOCK_AND_PRICE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage searchWithStockAndPrice(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.PRODUCT_SEARCH_WITH_STOCK_AND_PRICE
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.PRODUCT_GET_BY_ID_DESCRIPTION, response = ProductModel.class)
    @RequestMapping(value = "getVMProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getVMProduct(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/product/getVMProduct" ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        System.out.println("123456: " + responseMessage.responseObj);
        return responseMessage;
    }

    @ApiOperation(value = "Get All Product List View", response = ProductModel.class)
    @RequestMapping(value = "getAllProductListView", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getProductListForView(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/product/getAllProductListView" ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "Get Unsaved Product List View", response = VMItemListingReportQuery.class)
    @RequestMapping(value = "getUnsavedItemListingReport", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getUnsavedItemListingReport(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/product/getUnsavedItemListingReport" ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.RE_NUMBER_ITEM_CODE_SAVE_DESCRIPTION, response = VMReNumberItemCode.class)
    @RequestMapping(value = InventoryModuleConstant.RE_NUMBER_ITEM_CODE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage saveItemCode(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.RE_NUMBER_ITEM_CODE_SAVE
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.RE_NUMBER_ITEM_CODE_GET_ALL_LINK_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = InventoryModuleConstant.RE_NUMBER_ITEM_CODE_GET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllItemCode(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.RE_NUMBER_ITEM_CODE_GET
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.PRODUCT_GET_ALL_LINK_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = InventoryModuleConstant.GET_ALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAll(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.GET_ALL
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.PRODUCT_GET_ALL_ACTIVE_AND_INACTIVE_LINK_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = InventoryModuleConstant.PRODUCT_GET_ALL_ACTIVE_AND_INACTIVE_LINK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllActiveAndInactive(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL+InventoryModuleConstant.PRODUCT_GET_ALL_ACTIVE_AND_INACTIVE_LINK
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.ADJUST_PRODUCT_OPENING_BALANCE_SAVE_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = InventoryModuleConstant.ADJUST_PRODUCT_OPENING_BALANCE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage saveAdjustItemOpeningBalance(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL + InventoryModuleConstant.ADJUST_PRODUCT_OPENING_BALANCE_SAVE
                , WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.ADJUST_PRODUCT_SELLING_PRICE_SAVE_DESCRIPTION, response = VMAdjustProductSellingPrice.class)
    @RequestMapping(value = InventoryModuleConstant.ADJUST_PRODUCT_SELLING_PRICE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage saveAdjustItemSellingPrice(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.PRODUCT_BASE_URL + InventoryModuleConstant.ADJUST_PRODUCT_SELLING_PRICE_SAVE
                , WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = InventoryModuleConstant.ADJUST_PRODUCT_OPENING_BALANCE_SAVE_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = "getAllAccountThroughInterModuleCommunication", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllAccountThroughInterModuleCommunication(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/inventory/getAllAccountThroughInterModuleCommunication"
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
}




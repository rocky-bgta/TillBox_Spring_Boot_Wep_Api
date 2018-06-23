/**
 * Created By: Md. Abdul Hannan
 * Created Date: 3/1/2018
 * Time: 11:10 AM
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */
package com.nybsys.tillboxweb.controllers.inventory;


import com.nybsys.tillboxweb.constant.InventoryModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.common.VMItemAdjustmentModel;
import com.nybsys.tillboxweb.models.inventory.ItemAdjustmentModel;
import com.nybsys.tillboxweb.models.inventory.ItemAdjustmentSaveModel;
import com.nybsys.tillboxweb.models.inventory.ProductModel;
import com.nybsys.tillboxweb.models.inventory.ReasonModel;
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
@RequestMapping(InventoryModuleConstant.INVENTORY_TRANSACTION_BASE_URL)
@Api(tags = "Inventory")
public class InventoryTransactionController {

    @ApiOperation(value = InventoryModuleConstant.INVENTORY_TRANSACTION_SEARCH_DESCRIPTION, response = ProductModel.class)
    @RequestMapping(value = InventoryModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(InventoryModuleConstant.INVENTORY_TRANSACTION_BASE_URL + InventoryModuleConstant.SEARCH, WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = VMItemAdjustmentModel.class)
    @RequestMapping(value = "getQuantityOnHandByProductID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getQuantityOnHandByProductID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/inventory/inventoryTransaction/getQuantityOnHandByProductID"
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = ItemAdjustmentSaveModel.class)
    @RequestMapping(value ="getItemAdjustmentFrontEndViewModel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage ItemAdjustment(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/inventory/inventoryTransaction/getItemAdjustmentFrontEndViewModel"
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = ItemAdjustmentModel.class)
    @RequestMapping(value ="saveItemAdjustment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage saveItemAdjustment(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/inventory/inventoryTransaction/saveItemAdjustment"
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = "", response = ReasonModel.class)
    @RequestMapping(value ="getAllReason", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllReason(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/inventory/inventoryTransaction/getAllReason"
                ,WORKER_INVENTORY_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

}

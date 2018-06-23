/**
 * Created By: Md. Rashed Khan Menon
 * Created Date: 05/03/2018
 * Time: 10:21
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */

package com.nybsys.tillboxweb.controllers.expense;

import com.nybsys.tillboxweb.constant.ExpenseModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.expense.ExpenseAdjustmentModel;
import com.nybsys.tillboxweb.models.expense.VMExpenseAdjustmentModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_EXPENSE_MODULE_TOPIC;

@RestController
@RequestMapping(ExpenseModuleConstant.EXPENSE_ADJUSTMENT_BASE_URL)
@Api(tags = "Expense")
public class ExpenseAdjustmentController {

    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_ADJUSTMENT_SAVE_DESCRIPTION, response = VMExpenseAdjustmentModel.class)
    @RequestMapping(value = ExpenseModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_ADJUSTMENT_BASE_URL+ExpenseModuleConstant.SAVE, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_ADJUSTMENT_SEARCH_DESCRIPTION, response = ExpenseAdjustmentModel.class)
    @RequestMapping(value = ExpenseModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_ADJUSTMENT_BASE_URL+ExpenseModuleConstant.SEARCH, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_ADJUSTMENT_GET_BY_ID_DESCRIPTION, response = ExpenseAdjustmentModel.class)
    @RequestMapping(value = ExpenseModuleConstant.GET_BY_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_ADJUSTMENT_BASE_URL+ExpenseModuleConstant.GET_BY_ID, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_ADJUSTMENT_DELETE_DESCRIPTION, response = ExpenseAdjustmentModel.class)
    @RequestMapping(value = ExpenseModuleConstant.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage delete(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_ADJUSTMENT_BASE_URL+ExpenseModuleConstant.DELETE, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
    
}

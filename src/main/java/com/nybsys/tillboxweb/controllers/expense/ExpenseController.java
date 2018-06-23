/**
 * Created By: Md. Rashed Khan Menon
 * Created Date: 28/03/2018
 * Time: 05:56
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */

package com.nybsys.tillboxweb.controllers.expense;


import com.nybsys.tillboxweb.constant.ExpenseModuleConstant;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.expense.BlankModel;
import com.nybsys.tillboxweb.models.expense.ExpenseModel;
import com.nybsys.tillboxweb.models.expense.VMExpenseModel;
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
@RequestMapping(ExpenseModuleConstant.EXPENSE_BASE_URL)
@Api(tags = "Expense", value = ExpenseModuleConstant.EXPENSE_CONTROLLER_NAME)
public class ExpenseController {

    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_SAVE_DESCRIPTION, response = VMExpenseModel.class)
    @RequestMapping(value = ExpenseModuleConstant.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_BASE_URL + ExpenseModuleConstant.SAVE, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_SEARCH_DESCRIPTION, response = ExpenseModel.class)
    @RequestMapping(value = ExpenseModuleConstant.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_BASE_URL + ExpenseModuleConstant.SEARCH, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_DELETE_DESCRIPTION, response = ExpenseModel.class)
    @RequestMapping(value = ExpenseModuleConstant.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage delete(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_BASE_URL + ExpenseModuleConstant.DELETE, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = ExpenseModuleConstant.EXPENSE_CATEGORIES_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = ExpenseModuleConstant.EXPENSE_CATEGORIES, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getExpenseCategories(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(ExpenseModuleConstant.EXPENSE_CATEGORIES_BASE_URL + ExpenseModuleConstant.EXPENSE_CATEGORIES, WORKER_EXPENSE_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock, publishedMessageId);

        return responseMessage;
    }
}

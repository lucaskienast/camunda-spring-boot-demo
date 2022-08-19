package org.kienast.camunda.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("ValidateOrder")
public class ValidateOrder implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(ValidateOrder.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n  ... ValidateOrder invoked by "
            + "activtyName='" + execution.getCurrentActivityName() + "'"
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", processDefinitionId=" + execution.getProcessDefinitionId()
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + ", variables=" + execution.getVariables()
            + " \n\n");

    LOGGER.info("Validate order execute method has been called!");
    // call other java classes and methods to perform different activities+
    String orderName = (String) execution.getVariable("orderName");
    LOGGER.info("orderName -> " + orderName);

    boolean valid = false;

    if (orderName.length() > 0) {
      LOGGER.info("Valid order");
      valid = true;
    } else {
      LOGGER.warning("Invalid order");
    }

    execution.setVariable("valid", valid);
  }

}

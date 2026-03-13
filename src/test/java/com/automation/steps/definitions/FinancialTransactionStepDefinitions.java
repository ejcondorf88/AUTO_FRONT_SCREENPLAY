package com.automation.steps.definitions;

import com.automation.screenplay.questions.TransactionList;
import com.automation.screenplay.tasks.AddTransaction;
import com.automation.screenplay.tasks.Login;
import com.automation.screenplay.tasks.Navigate;
import com.automation.screenplay.tasks.NavigateToTransactions;
import com.automation.screenplay.tasks.Register;
import com.automation.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class FinancialTransactionStepDefinitions {

    @Given("the visitor registers with name {string}, email {string}, and password {string}")
    public void registerVisitor(String name, String email, String password) {
        theActorCalled(name).wasAbleTo(
            Register.withData(name, email, password)
        );
    }

    @When("the user logs in with email {string} and password {string}")
    public void loginUser(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
            Navigate.to(Constants.LOGIN_URL),
            Login.withCredentials(email, password)
        );
    }

    @And("accesses the transactions module")
    public void openTransactionsModule() {
        theActorInTheSpotlight().attemptsTo(
            NavigateToTransactions.module()
        );
    }

    @And("registers a {string} transaction with description {string} for an amount of {int} and date {string}")
    public void registerTransaction(String type, String description, Integer amount, String date) {
        theActorInTheSpotlight().attemptsTo(
            AddTransaction.withData(type, description, String.valueOf(amount), date)
        );
    }

    @Then("the user should see the transaction {string} with amount {int} in the list")
    public void verifyTransactionInList(String description, Integer amount) {
        theActorInTheSpotlight().should(
            seeThat(TransactionList.descriptions(),
                hasItem(containsString(description))),
            seeThat(TransactionList.amounts(),
                hasItem(containsString(String.valueOf(amount))))
        );
    }
}
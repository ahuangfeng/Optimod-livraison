package lhexanome.optimodlivraison.ui.controller;

import lhexanome.optimodlivraison.platform.models.DemandeLivraison;
import lhexanome.optimodlivraison.platform.models.Plan;
import lhexanome.optimodlivraison.platform.models.Tournee;
import lhexanome.optimodlivraison.ui.controller.states.*;
import lhexanome.optimodlivraison.ui.orderaction.OrderEditorWindow;
import lhexanome.optimodlivraison.ui.planpreview.PlanPreviewActions;
import lhexanome.optimodlivraison.ui.planpreview.PlanPreviewWindow;
import lhexanome.optimodlivraison.ui.demandpreview.DemandPreviewActions;
import lhexanome.optimodlivraison.ui.demandpreview.DemandPreviewWindow;
import lhexanome.optimodlivraison.ui.welcome.WelcomeActions;
import lhexanome.optimodlivraison.ui.welcome.WelcomeWindow;

import java.io.File;

/**
 * Created by nathan on 17/10/17.
 */
public class Controller implements WelcomeActions, PlanPreviewActions, DemandPreviewActions {

    private WelcomeWindow welcomeWindow;
    private PlanPreviewWindow planPreviewWindow;
    private DemandPreviewWindow demandPreviewWindow;
    private OrderEditorWindow orderEditorWindow;
    
    private State currentState;


    public WelcomeState welcomeState;
    public ChoosePlanState choosePlanState;

    public PlanPreviewState planPreviewState;
    public ChooseDemandeState chooseDemandeState;

    public DemandPreviewState demandPreviewState;

    public OrderEditorState orderEditorState;

    public Plan plan;
    public DemandeLivraison demand;
    public Tournee tournee;


    public Controller() {

        welcomeWindow = new WelcomeWindow(this);
        planPreviewWindow = new PlanPreviewWindow(this);
        demandPreviewWindow = new DemandPreviewWindow(this);
        orderEditorWindow = new OrderEditorWindow(this);

        // WELCOME WINDOWS STATES
        welcomeState = new WelcomeState(this, welcomeWindow);
        choosePlanState = new ChoosePlanState(this, welcomeWindow);

        // PLAN_PREVIEW WINDOWS STATES
        planPreviewState = new PlanPreviewState(this, planPreviewWindow);
        chooseDemandeState = new ChooseDemandeState(this, planPreviewWindow);

        // DEMAND_PREVIEW WINDOWS STATES
        demandPreviewState = new DemandPreviewState(this, demandPreviewWindow);

        // ORDER_EDITOR WINDOWS STATES
        orderEditorState = new OrderEditorState(this, orderEditorWindow);


        currentState = welcomeState;
        welcomeWindow.open();
    }

    public void setCurrentState(State state){
        this.currentState = state;
    }


    @Override
    public void selectPlan(File xmlPlanFile) {
        currentState.selectPlan(planPreviewWindow, xmlPlanFile);
    }

    @Override
    public void clickChoosePlan() {
        currentState.clickChoosePlan();
    }

    @Override
    public void clickCancelPlan() {
        currentState.clickCancelPlan();
    }

    @Override
    public void clickGoHome() {
        currentState.clickGoHome(welcomeWindow);
    }

    @Override
    public void clickComputeTour() {
        currentState.clickComputeTour(orderEditorWindow);
    }

    @Override
    public void selectDemand(File xmlDemandFile) {
        currentState.selectDemand(demandPreviewWindow, xmlDemandFile);
    }

    @Override
    public void clickChooseDemand() {
        currentState.clickChooseDemand();
    }

    @Override
    public void clickCancelDemand() {
        currentState.clickChooseDemand();
    }

    public void closeWondow() {
        currentState.closeWindows();
    }
}

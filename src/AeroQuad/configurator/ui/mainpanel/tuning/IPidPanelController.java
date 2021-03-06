package AeroQuad.configurator.ui.mainpanel.tuning;

import AeroQuad.configurator.communication.messaging.request.IRequest;
import AeroQuad.configurator.messagesdispatcher.PIDData;

public interface IPidPanelController
{
    void setUserLevel(UserLevel userLevel);

    IRequest getRequest();

    boolean haveBeenSincedOnce();

    boolean isUserDataInSinced();

    String getSetPidCommand();

    void userDefaultButtonPressed();

    void setHaveNotBeenSincedOnce();

}

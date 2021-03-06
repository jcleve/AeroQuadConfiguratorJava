package AeroQuad.configurator.ui.mainpanel.monitoring.vehiclestatus.motordisplaypanel;

import AeroQuad.configurator.communication.ISerialCommunicator;
import AeroQuad.configurator.communication.messaging.IMessageDefinition;
import AeroQuad.configurator.messagesdispatcher.IMessageDispatcher;
import AeroQuad.configurator.ui.mainpanel.monitoring.motordisplaypanel.IMotorDisplayController;
import AeroQuad.configurator.ui.mainpanel.monitoring.motordisplaypanel.IMotorDisplayPanel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MotorDisplayPanelController implements IMotorDisplayController
{
    private final ISerialCommunicator _communicator;
    private IMotorDisplayPanel _panel;

    public MotorDisplayPanelController(final IMessageDispatcher messageDispatcher, final ISerialCommunicator communicator)
    {
        _communicator = communicator;


        messageDispatcher.addListener(IMessageDispatcher.NB_MOTORS_PROPERTY_KEY, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setNbMotor((Integer) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR1_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor1CommandValue((String) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR2_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor2CommandValue((String) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR3_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor3CommandValue((String) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR4_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor4CommandValue((String) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR5_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor5CommandValue((String) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR6_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor6CommandValue((String) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR7_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor7CommandValue((String) evt.getNewValue());
            }
        });
        messageDispatcher.addListener(IMessageDispatcher.MOTOR8_THROTTLE_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                _panel.setMotor8CommandValue((String) evt.getNewValue());
            }
        });

        messageDispatcher.addListener(IMessageDispatcher.CONNECTION_STATE_CHANGE, new PropertyChangeListener()
        {
            @Override
            public void propertyChange(final PropertyChangeEvent evt)
            {
                final boolean isConnected = (boolean)evt.getNewValue();
                if (!isConnected)
                {
                    _panel.setDisconnected();
                }
            }
        });
    }

    @Override
    public void setPanel(final IMotorDisplayPanel panel)
    {
        _panel = panel;
        _panel.setEditable(false);
    }

    @Override
    public void setActivated(final boolean activated)
    {
        if (activated)
        {
            _communicator.sendCommand(IMessageDefinition.REQUEST_STOP_SENDING);
        }
    }
}

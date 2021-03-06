package AeroQuad.configurator.ui.mainpanel.tuning.batterymonitor;

import AeroQuad.configurator.ui.mainpanel.tuning.singleparamconfigpanel.SingleParamConfigPanel;
import AeroQuad.configurator.ui.mainpanel.tuning.syncedstate.SyncedStatePanel;
import AeroQuad.configurator.ui.uiutils.UiUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BatteryMonitorPidPanel extends JPanel implements IBatteryMonitorPidPanel
{
    private final IBatteryMonitorPidPanelController _controller;

    private final SingleParamConfigPanel _alarmVoltagePanel = new SingleParamConfigPanel("<HTML><CENTER>Alarm<BR>Voltage</CENTER></HTML>");
    private final SingleParamConfigPanel _throttleTargetPanel = new SingleParamConfigPanel("<HTML><CENTER>Throttle<BR>Target</CENTER></HTML>");
    private final SingleParamConfigPanel _goingDownTimePanel = new SingleParamConfigPanel("<HTML><CENTER>Going Down<BR>Time</CENTER></HTML>");
    private final SyncedStatePanel _syncStatePanel = new SyncedStatePanel();

    private final JButton _resetDefaultButton = new JButton("<HTML><CENTER>Reset<BR>Default</CENTER></HTML>");
    private JPanel _centerPanel;

    public BatteryMonitorPidPanel(final IBatteryMonitorPidPanelController batteryMonitorPidPanelController)
    {
        _controller = batteryMonitorPidPanelController;

        _controller.setPanel(this);

        initPanel();

        connectListener();
    }

    private void initPanel()
    {
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.black,4));

        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JLabel headerLabel = new JLabel("Battery Monitor");
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setPreferredSize(new Dimension(0, UiUtils.HEATHER_PREFERED_HEIGHT));
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        headerLabel.setBorder(new LineBorder(Color.black, 1));

        _alarmVoltagePanel.setPreferredSize(new Dimension(152,0));

        _centerPanel = new JPanel(new GridLayout(1,5));
        _centerPanel.add(_alarmVoltagePanel);
        _centerPanel.add(_throttleTargetPanel);
        _centerPanel.add(_goingDownTimePanel);
        _centerPanel.add(_resetDefaultButton);
        _centerPanel.add(_syncStatePanel);

        mainPanel.add(_centerPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.WEST);
    }

    private void connectListener()
    {
        _alarmVoltagePanel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _controller.userAlarmVoltageChanged(_alarmVoltagePanel.getText());
            }
        });
        _throttleTargetPanel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _controller.userThrottleTargetChanged(_throttleTargetPanel.getText());
            }
        });
        _goingDownTimePanel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _controller.userGoingDownTimeChanged(_goingDownTimePanel.getText());
            }
        });
        _resetDefaultButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                _controller.userDefaultButtonPressed();
            }
        });
    }

    @Override
    public void setSinced(final boolean synced)
    {
        _syncStatePanel.setSynced(synced);
    }

    @Override
    public void setAlarmVoltage(final String alarmVoltage)
    {
        _alarmVoltagePanel.setText(alarmVoltage);
    }

    @Override
    public void setThrottleTarget(final String throttleTarget)
    {
        _throttleTargetPanel.setText(throttleTarget);
    }

    @Override
    public void setGoingDownTime(final String goingDownTime)
    {
        _goingDownTimePanel.setText(goingDownTime);
    }
}

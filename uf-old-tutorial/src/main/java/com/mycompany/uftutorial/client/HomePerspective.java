package com.mycompany.uftutorial.client;

import javax.enterprise.context.ApplicationScoped;

import org.uberfire.client.annotations.Perspective;
import org.uberfire.client.annotations.WorkbenchPerspective;
import org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.MultiTabWorkbenchPanelPresenter;
import org.uberfire.mvp.impl.DefaultPlaceRequest;
import org.uberfire.workbench.model.CompassPosition;
import org.uberfire.workbench.model.PerspectiveDefinition;
import org.uberfire.workbench.model.impl.PanelDefinitionImpl;
import org.uberfire.workbench.model.impl.PartDefinitionImpl;
import org.uberfire.workbench.model.impl.PerspectiveDefinitionImpl;

@ApplicationScoped
@WorkbenchPerspective(
        identifier = "com.mycompany.uftutorial.client.HomePerspective",
        isDefault = true)
public class HomePerspective {

  @Perspective
  public PerspectiveDefinition getPerspective() {
    final PerspectiveDefinition p = new PerspectiveDefinitionImpl(MultiTabWorkbenchPanelPresenter.class.getName());
    p.setName(getClass().getName());

    p.getRoot().addPart(
            new PartDefinitionImpl(
                    new DefaultPlaceRequest(HelloWorldScreen.class.getName())));

    PanelDefinitionImpl westPanel = new PanelDefinitionImpl(MultiListWorkbenchPanelPresenter.class.getName());
    p.getRoot().insertChild(CompassPosition.WEST, westPanel);
    westPanel.setWidth(250);
    westPanel.addPart(
            new PartDefinitionImpl(
                    new DefaultPlaceRequest(MoodScreen.class.getName())));

    return p;
  }

}

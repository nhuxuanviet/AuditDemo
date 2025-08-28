package com.company.auditdemo.view.extentitylog;

import com.vaadin.flow.router.Route;
import io.jmix.auditflowui.view.entitylog.EntityLogView;
import io.jmix.flowui.view.DefaultMainViewParent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "audit/entitylog", layout = DefaultMainViewParent.class)
@ViewController(id = "entityLog.view")
@ViewDescriptor(path = "ext-entity-log-view.xml")
public class ExtEntityLogView extends EntityLogView {

}
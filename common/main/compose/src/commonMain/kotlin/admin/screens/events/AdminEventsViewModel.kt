package admin.screens.events

import admin.screens.events.models.AdminEventsAction
import admin.screens.events.models.AdminEventsEvent
import admin.screens.events.models.AdminEventsViewState
import com.adeo.kviewmodel.BaseSharedViewModel

class AdminEventsViewModel : BaseSharedViewModel<AdminEventsViewState, AdminEventsAction, AdminEventsEvent>(
    initialState = AdminEventsViewState()
) {
    override fun obtainEvent(viewEvent: AdminEventsEvent) {
    }
}
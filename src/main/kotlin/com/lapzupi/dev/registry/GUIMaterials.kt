package com.lapzupi.dev.registry

import xyz.xenondevs.nova.api.Nova


/**
 *
 * @author sarhatabaot
 */
object GUIMaterials {
    private val nova: Nova = Nova.getNova()
    
    val ARROW_PROGRESS = nova.itemRegistry["machines:gui_arrow_progress"]
}
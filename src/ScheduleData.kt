/**
 * Created by chang on 2016-11-07.
 */
data class ScheduleData(val upSchedule: String = "", val downSchedule: String = "") {
    override fun toString(): String = "$upSchedule-$downSchedule"
}
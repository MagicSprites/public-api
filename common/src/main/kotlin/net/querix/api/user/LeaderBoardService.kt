package net.querix.api.user

import net.querix.api.user.objects.Contest
import net.querix.api.user.objects.Leader

interface LeaderBoardService {
    fun getLeadersBy(contest: Contest, limit: Int): List<Leader>
}
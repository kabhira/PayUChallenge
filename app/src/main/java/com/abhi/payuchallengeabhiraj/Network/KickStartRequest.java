package com.abhi.payuchallengeabhiraj.Network;

import com.abhi.payuchallengeabhiraj.model.KickStartResponseElement;

/**
 *  Author: Abhiraj Khare
 *  Description: Network request to be executed by Volley to fetch json.
 */

public class KickStartRequest  extends VolleyRequest<KickStartResponseElement[]> {

    private static String url = "http://starlord.hackerearth.com/kickstarter";
    public KickStartRequest(){
        super(Method.GET, url, KickStartResponseElement[].class, null, null, null);
    }
}
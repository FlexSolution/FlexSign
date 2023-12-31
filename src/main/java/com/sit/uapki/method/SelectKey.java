/*
 * Copyright (c) 2021, The UAPKI Project Authors.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are 
 * met:
 * 
 * 1. Redistributions of source code must retain the above copyright 
 * notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright 
 * notice, this list of conditions and the following disclaimer in the 
 * documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS 
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED 
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.sit.uapki.method;

import com.sit.uapki.cert.CertId;
import com.sit.uapki.common.PkiData;
import com.sit.uapki.common.PkiOid;
import com.sit.uapki.key.KeyId;

import java.util.ArrayList;

/**
 * Classes for SELECT_KEY-method
 */
public interface SelectKey {
    static final String METHOD = "SELECT_KEY";

    class Parameters {
        final String id;

        public Parameters (KeyId keyId) {
            this.id = keyId.toString();
        }
    }   //  end class Parameters

    class Result {
        ArrayList<String> signAlgo;
        String certId;      //  Optional, nullable
        String certificate; //  Optional, nullable
        boolean exportable; //  Optional, default: false

        public ArrayList<PkiOid> getKeyMechanisms () {
            return getSignAlgo();
        }

        public ArrayList<PkiOid> getSignAlgo () {
            ArrayList<PkiOid> rv_list = new ArrayList<>();
            for (int i = 0; i < signAlgo.size(); i++) {
                rv_list.add(new PkiOid(signAlgo.get(i)));
            }
            return rv_list;
        }

        public CertId getCertId () {
            return new CertId(certId);
        }

        public PkiData getCertificate () {
            return new PkiData(certificate);
        }
        
        public boolean isExportable () {
            return exportable;
        }
    }   //  end class Result

}

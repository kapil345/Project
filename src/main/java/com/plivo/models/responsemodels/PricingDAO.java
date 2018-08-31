package com.plivo.models.responsemodels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingDAO {

    private String api_id;
    private String country;
    private int country_code;
    private String country_iso;
    private Message message;
    private PhoneNumbers phone_numbers;
    private Voice voice;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Message {

        private Inbound inbound;
        private Outbound outbound;
        private OutBoundNetworkList[] outbound_networks_list;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public class Inbound {

            private String rate;

        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public class Outbound {

            private String rate;
        }

        public class OutBoundNetworkList {

            private String group_name;
            private String rate;

        }


    }


    public class PhoneNumbers {

        private Local local;
        private Shortcode shortcode;
        private Tollfree tollfree;


        public class Local {

            private String rate;
            private Rates[] rates;

        }

        public class Shortcode {

            private String rate;
            private Rates[] rates;

        }

        public class Tollfree {

            private String rate;
            private Rates[] rates;

        }

        public class Rates {

            private List<String> capabilities;
            private String rental_rate;
            private String setup_rate;
        }

    }


    public class Voice {

        Inbound inbound;
        Outbound outbound;

        public class Inbound {

            IP ip;
            Local local;
            Tollfree tollfree;

            public class IP {
                String rate;
            }

            public class Local {

                String rate;

            }

            public class Tollfree {

                String rate;
            }


        }

        public class Outbound {


            Inbound.IP ip;
            Inbound.Local local;
            Inbound.Tollfree tollfree;
            Rates[] rates;


            public class Rates {

                List<String> prefix;
                String rate;
            }

        }
    }


}

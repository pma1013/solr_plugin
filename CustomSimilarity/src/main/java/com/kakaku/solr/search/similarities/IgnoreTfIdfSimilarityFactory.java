package com.kakaku.solr.search.similarities;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.kakaku.lucene.search.similarities.IgnoreTfIdfSimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.search.similarities.TFIDFSimilarity; // javadoc
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.schema.SimilarityFactory;

/**
 * Factory for {@link IgnoreIDFSimilarity}
 * <p>
 * DefaultSimilarity is Lucene's default scoring implementation, based
 * upon the Vector Space Model.
 * <p>
 * Optional settings:
 * <ul>
 *   <li>discountOverlaps (bool): Sets
 *       {@link DefaultSimilarity#setDiscountOverlaps(boolean)}</li>
 * </ul>
 * @see TFIDFSimilarity
 * @lucene.experimental
 */
public class IgnoreTfIdfSimilarityFactory extends SimilarityFactory {

  /** Init param name for specifying the value to use in 
   * {@link IgnoreIDFSimilarity#setDiscountOverlaps(boolean)} 
   */
  public static final String DISCOUNT_OVERLAPS = "discountOverlaps";
  public static final String IGNORE_TF_FLG = "ignoreTfFlg";
  public static final String IGNORE_IDF_FLG = "ignoreIdfFlg";

  /** 
   * Controls the value of {@link IgnoreIDFSimilarity#setDiscountOverlaps(boolean)} 
   * on newly constructed instances of {@link IgnoreIDFSimilarity}
   */
  protected boolean discountOverlaps = true;
  protected boolean ignoreTfFlg = false;
  protected boolean ignoreIdfFlg = false;

  @Override
  public void init(SolrParams params) {
    super.init(params);
    discountOverlaps = params.getBool(DISCOUNT_OVERLAPS, true);
    ignoreTfFlg = params.getBool(IGNORE_TF_FLG, false);
    ignoreIdfFlg = params.getBool(IGNORE_IDF_FLG, false);
  }

  @Override
  public Similarity getSimilarity() {
    IgnoreTfIdfSimilarity sim = new IgnoreTfIdfSimilarity();
    sim.setDiscountOverlaps(discountOverlaps);
    sim.setIgnoreTfFlg(ignoreTfFlg);
    sim.setIgnoreIdfFlg(ignoreIdfFlg);
    return sim;
  }
}
